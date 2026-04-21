import java.util.Scanner;

public class BattleManeger {
    private String Escolha;
    private String Resposta;
    private Scanner Leitor = new Scanner(System.in);
    
    public void SetterEscolha(String Escolha){
        this.Escolha = Escolha.toLowerCase();
    }


   public void Acao(Personagem Jogador, Personagem Inimigo, Pergunta Pergunta){
    
    if(this.Escolha.equals("responder")){
        System.out.println(Pergunta.getEnunciado());
        this.Resposta = Leitor.nextLine().toLowerCase();

        if(this.Resposta.charAt(0) == Pergunta.getGabarito().charAt(0)){
            Inimigo.setVida(Inimigo.getVida() - Jogador.getDano());
        }
        else{
            Jogador.setVida(Jogador.getVida() - Inimigo.getDano());
        }

    } else if(this.Escolha.equals("defender")){
        Jogador.setVida(Jogador.getVida() - (Inimigo.getDano() - Jogador.getDefesa()));

    } else if(this.Escolha.equals("habilidades")){
        Resposta = Leitor.nextLine().toLowerCase();
        // Implementar Habilidades com if usando "Resposta" e "Jogador.GetterQI" como parâmetro.
        if(Resposta.equals("eliminar") && Jogador.getQI() >= 2 && Pergunta instanceof PerguntaMultiplaEscolha){
            Jogador.getHabilidades().Eliminar((PerguntaMultiplaEscolha) Pergunta);
            Jogador.setQI(Jogador.getQI() - 2);
        }
        else{
            System.out.println("Habilidade não compatível com a pergunta ou QI insuficiente.");
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
            
            

