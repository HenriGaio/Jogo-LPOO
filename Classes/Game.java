import java.util.Scanner;

public class Game 
{
	public static void main(String[] args) 
	{
		BattleManager rodada = new BattleManager();
		QuestionManager QuestionManager = new QuestionManager();
		
		Scanner scanner = new Scanner(System.in);
		String opcao = "";

		// Seleção de Personagem
        System.out.println("Escolha sua classe: ");
        System.out.println("1 - Combatente (Foco em Dano)");
        System.out.println("2 - Estrategista (Foco em QI)");
        System.out.println("3 - Tank (Foco em Resistência)");
        System.out.print("Opção: ");
        
        String inputEscolha = scanner.nextLine().trim();
        // Loop que prende o usuário até ele digitar 1, 2 ou 3
        while (!inputEscolha.equals("1") && !inputEscolha.equals("2") && !inputEscolha.equals("3")) {
            System.out.print("Opção inválida! Por favor, digite 1, 2 ou 3: ");
            inputEscolha = scanner.nextLine().trim();
        }
        
        int escolha = Integer.parseInt(inputEscolha);

        Personagem player;
        if (escolha == 1) 
        {
            player = new Combatente();
        } 
        else if (escolha == 2)
        {
            player = new Estrategista();
        }
        else 
        {   
            player = new Tank();
        }
       	
       	// Listas com os nomes dos arquivos separados por dificuldade
        String[] arquivosPerguntas = {"PerguntasFaceis.txt", "PerguntasMedias.txt", "PerguntasDificeis.txt"};
        String[] arquivosGabaritos = {"GabaritoFaceis.txt", "GabaritoMedias.txt", "GabaritoDificeis.txt"};
       	
       	// Loop de Fases (Níveis)
       	for (int nivel = 0; nivel < 3; nivel++) {
       	
       		// Escalonamento do inimigo: Mais vida e menos dano a cada nível
       			
       		int vidaInimigo = 110 + (nivel * 40); // Nv 1: 110 | Nv 2: 150 | Nv 3: 190
       		int danoInimigo = 15  - (nivel * 3);   // Nv 1: 15 | Nv 2: 12 | Nv 3: 9
       		int defesaInimigo = 10;
       		String nomeInimigo = "Bug Crônico Nv " + (nivel + 1);
       		
       		Personagem inimigo = new Inimigos(vidaInimigo, danoInimigo, defesaInimigo, nomeInimigo);
       		
       		System.out.println("\n=========================================");
        	System.out.println("UMA BATALHA FOI INICIADA - NÍVEL " + (nivel + 1) + "!");
        	System.out.println("Nome do adversário: " + inimigo.getNome());
        	System.out.println("=========================================");
       		
       		// Reseta o gerenciador de perguntas para ler o novo arquivo do nível atual
       		
       		QuestionManager.reset();
       		
       		int numeroDaRodada = 1;
       		
       		// Loop de Batalha
       		while (player.estaVivo() && inimigo.estaVivo()) 
       		{
       			if (!opcao.toLowerCase().equals("habilidades")) {	
       				QuestionManager.AtualizarPergunta(arquivosPerguntas[nivel], arquivosGabaritos[nivel], inimigo);
				}
	   			
				System.out.println("\n--- Rodada " + numeroDaRodada + " ---");
       			System.out.println(player.getNome() + " HP: " + player.getVida() + " QI: " + player.getQI() + " | " + inimigo.getNome() + " HP: " + inimigo.getVida());
        		System.out.println("-----------------------------------------");
       			System.out.println("\nPergunta: " + QuestionManager.getPergunta().getEnunciado());
		
        		System.out.println("\nO que você deseja fazer ?");
        		System.out.println("responder");
        		System.out.println("defender");
        		System.out.println("habilidades");
        		System.out.print("Opção: ");
        		opcao = scanner.nextLine();
        		
        		// Validação da Ação do Jogador
                while (!opcao.equals("responder") && !opcao.equals("defender") && !opcao.equals("habilidades")) {
                    System.out.print("Ação inválida! Digite 'responder', 'defender' ou 'habilidades': ");
                    opcao = scanner.nextLine().toLowerCase().trim();
                }
        		System.out.println("");
        		
        		rodada.setEscolha(opcao); 
       			rodada.Acao(player, inimigo, QuestionManager.getPergunta());
       			
       			numeroDaRodada++;
       		
       		}
       		// Verificação de fim de nível ou fim de jogo
			if (!player.estaVivo()) 
			{
				System.out.println("\nVocê foi derrotado! Fim de jogo.");
				break; // Sai do loop de níveis, pois o jogador morreu
			} 
			else if (!inimigo.estaVivo()) 
			{
				System.out.println("\nParabéns! Você derrotou o " + inimigo.getNome() + "!");
            	if (nivel < 2) 
            	{
            		System.out.println("Prepare-se para o próximo nível...");
				}
				else 
				{
        			System.out.println("Você concluiu todos os desafios! VOCÊ VENCEU O JOGO!");
        		}
			}
		}
       	scanner.close();
       	
       	
       	
	} // fim da main
}
