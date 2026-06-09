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


   public void Acao(Personagem Jogador, Personagem Inimigo, Pergunta Pergunta){
    if (ataqueTotal == 0 && defesaTotal == 0){
        ataqueTotal = Jogador.getDano();
        defesaTotal = Jogador.getDefesa();
    }

    if(this.Escolha.equals("responder")){
        System.out.print("Digite sua resposta (Letra): ");
        this.Resposta = Leitor.nextLine().toLowerCase();

        if(this.Resposta.charAt(0) == Pergunta.getGabarito().charAt(0)){
            Inimigo.setVida(Inimigo.getVida() - ataqueTotal);
            System.out.printf("Você acertou e causou %d de dano ", ataqueTotal);
            
            if (ataqueTotal != Jogador.getDano()){
                ataqueTotal =  Jogador.getDano();
            }
        }
        
        else{
            Jogador.setVida(Jogador.getVida() - Inimigo.getDano());
            System.out.printf("Você errou e recebeu %d de dano ", Inimigo.getDano());
        }

    } else if(this.Escolha.equals("defender")){
        Jogador.setVida(Jogador.getVida() - (Inimigo.getDano() - defesaTotal));
        System.out.printf("Você defendeu e recebeu %d de dano ", Inimigo.getDano() - defesaTotal);
        
        if (defesaTotal != Jogador.getDefesa()){
                defesaTotal =  Jogador.getDefesa();
        }

    } else if(this.Escolha.equals("habilidades")){
        System.out.println("Escolha uma habilidade:");
        
        if (Jogador instanceof Estrategista) {
            System.out.println("- Eliminar (Custo: 2 QI) - Elimina uma alternativa errada (apenas para perguntas de múltipla escolha)");
        } if (Jogador instanceof Combatente) {
            System.out.println("- Crítico (Custo: 3 QI) - Aumenta o dano do próximo ataque em 50%");
        } else if (Jogador instanceof Tank) {
            System.out.println("- Fortalecer (Custo: 3 QI) - Aumenta a defesa em 50% para a próxima rodada");
        }
        
        Resposta = Leitor.nextLine().toLowerCase();
        // Implementar Habilidades com if usando "Resposta" e "Jogador.GetterQI" como parâmetro.
        
        if(Resposta.toLowerCase().equals("eliminar") && Jogador.getQI() >= 2 && Pergunta instanceof PerguntaMultiplaEscolha && Jogador instanceof Estrategista){
            Jogador.getHabilidades().Eliminar((PerguntaMultiplaEscolha) Pergunta);
            Jogador.setQI(Jogador.getQI() - 2);
        }
        else if (Resposta.toLowerCase().equals("critico") && Jogador.getQI() >= 3 && Pergunta instanceof PerguntaMultiplaEscolha && Jogador instanceof Combatente){
            ataqueTotal = (int) Jogador.getHabilidades().Critico(Jogador);
            Jogador.setQI(Jogador.getQI() - 3);
        }
        else if (Resposta.toLowerCase().equals("fortalecer") && Jogador.getQI() >= 3 && Pergunta instanceof PerguntaMultiplaEscolha && Jogador instanceof Tank){
            defesaTotal = (int) Jogador.getHabilidades().Fortalecer(Jogador);
            Jogador.setQI(Jogador.getQI() - 3);
        }
    }
    
   
    if(!this.Escolha.equals("defender") && Jogador.getQI() < 10){
        
        if(Jogador instanceof Estrategista){
            Jogador.setQI(Jogador.getQI() + 2);
        }
        else{
            Jogador.setQI(Jogador.getQI() + 1);
        }


    }
   
 }

}
            
            

