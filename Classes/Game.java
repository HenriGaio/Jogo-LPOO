public class Game 
{
	public static void main(String[] args) 
	{
		BattleManager rodada = new BattleManager();
		Pergunta perguntaMEscolha = new PerguntaMultiplaEscolha();
		Pergunta perguntaVOuF = new PerguntaCertoOuErrado();
		
		Scanner scanner = new Scanner(System.in);
		
		// Seleção de Personagem
        System.out.println("Escolha sua classe: ");
        System.out.println("1 - Combatente (Foco em Dano)");
        System.out.println("2 - Estrategista (Foco em QI)");
        System.out.println("3 - Tank (Foco em Resistência)");
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

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
       	
       	//iniciar batalha com o inimigo 1
       	
       	int vidaInimigo1 = 60;
       	int danoInimigo1 = 15;
       	int defesaInimigo1 = 10;
       	String nomeInimigo1 = "Bug Crônico";
       	
       	Personagem inimigo1 = new inimigos(vidaInimigo1 , danoInimigo1, defesaInimigo1, nomeInimigo1);
       	
       	System.out.println("Uma batalha foi iniciada ! ");
       	System.out.println("Nome do adversário: " + inimigo1.getNome());
       	
       	
       	int numeroDaRodada = 1;
       	while (player.estaVivo() && inimigo1.estaVivo()) 
       	{
       	
       	perguntaMEscolha.atualizarPergunta();
        System.out.println("O que você deseja fazer ?");
        System.out.println("responder");
        System.out.println("defender");
        System.out.println("habilidades");
        System.out.print("Opção: ");
        String escolha = scanner.nextLine();
        
        Rodada.setEscolha(escolha); 
       	Rodada.Acao(player, inimigo1, perguntaMEscolha);
       	
       	numeroDaRodada++;
       	}
       	
       	
       	
       	
       	
	} // fim da main
}
