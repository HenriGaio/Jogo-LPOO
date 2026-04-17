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
        System.out.println(Pergunta.GetterEnunciado());
        this.Resposta = Leitor.nextLine().toLowerCase();

        if(this.Resposta.charAt(0) == Pergunta.GetterGabarito().charAt(0)){
            Inimigo.SetterVida(Inimigo.GetterVida() - Jogador.GetterDano());
        }
        else{
            Jogador.SetterVida(Jogador.GetterVida() - Inimigo.GetterDano());
        }

    } else if(this.Escolha.equals("defender")){
        Jogador.SetterVida(Jogador.GetterVida() - (Inimigo.GetterDano() - Jogador.GetterDefesa()));

    } else if(this.Escolha.equals("habilidades")){
        Resposta = Leitor.nextLine().toLowerCase();
        // Implementar Habilidades com if usando "Resposta" e "Jogador.GetterQI" como parâmetro.
        if(Resposta.equals("eliminar") && Jogador.GetterQI() >= 2 && Pergunta instanceof PerguntaMultiplaEscolha){
            Jogador.GetterHabilidades().Eliminar((PerguntaMultiplaEscolha) Pergunta);
            Jogador.SetterQI(Jogador.GetterQI() - 2);
        }
        else{
            System.out.println("Habilidade não compatível com a pergunta ou QI insuficiente.");
        }
    }
    
   
    if(!this.Escolha.equals("defender") && Jogador.GetterQI() < 10){
        
        if(Jogador instanceof Estrategista){
            Jogador.SetterQI(Jogador.GetterQI() + 2);
        }
        else{
            Jogador.SetterQI(Jogador.GetterQI() + 1);
        }


    }
   
 }

}
            
            

