import java.util.Scanner;

public class BattleManager {
    private String Escolha;
    private String Resposta;
    private Scanner Leitor = new Scanner(System.in);
    private int ataqueTotal;
    private int defesaTotal;

    public void setEscolha(String Escolha){
        this.Escolha = Escolha.toLowerCase();
    }
    
    public void setAtaqueTotal(int ataqueTotal) {
        this.ataqueTotal = ataqueTotal;
    }

    public void setDefesaTotal(int defesaTotal) {
        this.defesaTotal = defesaTotal;
    }

   public void Acao(Personagem Jogador, Personagem Inimigo, Pergunta Pergunta){
    if (ataqueTotal == 0 && defesaTotal == 0){
        ataqueTotal = Jogador.getDano();
        defesaTotal = Jogador.getDefesa();
    }

    if(this.Escolha.equals("responder")){
        System.out.print("Digite sua resposta (Letra): ");
        // .trim() remove espaços extras acidentais digitados pelo usuário
        this.Resposta = Leitor.nextLine().toLowerCase().trim();

        boolean acertou = false;
        
        // Lógica adaptada para a nova Pergunta Fill The Blank
        if (Pergunta instanceof PerguntaFillTheBlank) {
            // Se for preencher lacuna, verifica se a string inteira é igual ao gabarito
            if (this.Resposta.equalsIgnoreCase(Pergunta.getGabarito().trim())) {
                acertou = true;
            }
        } else {
            // Se for múltipla escolha ou certo/errado, verifica apenas o primeiro caractere
            if (this.Resposta.length() > 0 && this.Resposta.charAt(0) == Pergunta.getGabarito().toLowerCase().charAt(0)) {
                acertou = true;
            }
        }
        
        if(acertou){
            Inimigo.setVida(Inimigo.getVida() - ataqueTotal);
            System.out.printf("Você acertou e causou %d de dano! \n", ataqueTotal);
            
            if (ataqueTotal != Jogador.getDano()){
                ataqueTotal =  Jogador.getDano();
            }
        }
        
        else
        {
            Jogador.setVida(Jogador.getVida() - Inimigo.getDano());
            System.out.printf("Você errou e recebeu %d de dano \n", Inimigo.getDano());
        }

    } else if(this.Escolha.equals("defender")){
        Jogador.setVida(Jogador.getVida() - (Inimigo.getDano() - defesaTotal));
        System.out.printf("Você defendeu e recebeu %d de dano \n ", Inimigo.getDano() - defesaTotal);
        
        if (defesaTotal != Jogador.getDefesa()){
                defesaTotal =  Jogador.getDefesa();
        }

    } else if(this.Escolha.equals("habilidades")) 
    	{
    
    		// 1. Verifica se o jogador possui uma habilidade (se ele implementa a interface)
    		if (Jogador instanceof HabilidadeEspecial) {
        		HabilidadeEspecial hab = (HabilidadeEspecial) Jogador;
        		
        		System.out.println("Escolha uma habilidade:");
        		System.out.println(hab.getDescricaoHabilidade());
        		System.out.print("Opção: ");
        		
        		Resposta = Leitor.nextLine().toLowerCase().trim();
        		
        		
        		while (!Resposta.equals(hab.getNomeHabilidade())) {
            		System.out.print("Habilidade inválida! Digite o nome da habilidade mostrada acima: ");
            		Resposta = Leitor.nextLine().toLowerCase().trim();
        		}
        		
        		
        		if (Jogador.getQI() >= hab.getCustoQI()) {
            		hab.executarHabilidade(this, Pergunta);
        		} else {
            		System.out.println("QI insuficiente!");
        		}
    		}
		}
    
   
    if(this.Escolha.equals("responder") && Jogador.getQI() < 10){
        
        if(Jogador instanceof Estrategista){
            Jogador.setQI(Jogador.getQI() + 2);
        }
        else{
            Jogador.setQI(Jogador.getQI() + 1);
        }


    }
   
 }

}
            
            

