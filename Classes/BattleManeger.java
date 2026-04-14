import java.util.Scanner;

public class BattleManeger {
    private String Escolha;
    private String Resposta;
    private Scanner Leitor = new Scanner(System.in);
    
    public void SetterEscolha(String Escolha){
        this.Escolha = Escolha;
    }


   public void Acao(Personagem Jogador, Personagem Inimigo, Pergunta Pergunta){
    if(this.Escolha.equals("Responder")){
        System.out.println(Pergunta.GetterEnunciado());
        this.Resposta = Leitor.nextLine();

        if(this.Resposta.equals(Pergunta.GetterGabarito())){
            Inimigo.SetterVida(Inimigo.GetterVida() - Jogador.GetterDano());
        }
        else{
            Jogador.SetterVida(Jogador.GetterVida() - Inimigo.GetterDano());
        }

    } else if(this.Escolha.equals("Defender")){
        Jogador.SetterVida(Jogador.GetterVida() - (Inimigo.GetterDano() - Jogador.GetterDefesa()));

    } else if(this.Escolha.equals("Habilidades")){
        Resposta = Leitor.nextLine();
        // Implementar Habilidades com if usando "Resposta" e "Jogador.GetterQI" como parâmetro.
    }
    
   
    if(!this.Escolha.equals("Defender") && Jogador.GetterQI() < 10){
        
        if(Jogador instanceof Estrategista){
            Jogador.SetterQI(Jogador.GetterQI() + 2);
        }
        else{
            Jogador.SetterQI(Jogador.GetterQI() + 1);
        }


    }
   
 }

}
            
            

