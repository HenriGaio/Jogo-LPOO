import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Pergunta{
    protected String Enunciado;
    protected String Gabarito;
    protected static BufferedReader brPergunta;
    protected static BufferedReader brGabarito;
    protected boolean flagLeitor = false;


    public String GetterEnunciado(){
        return this.Enunciado;
    }
    public void SetterEnunciado(String Enunciado){
        this.Enunciado = Enunciado;
    }
    public String GetterGabarito(){
        return this.Gabarito;
    }
    public void SetterGabarito(String Gabarito){
        this.Gabarito = Gabarito;
    }

    public void AtualizarPergunta(String CaminhoPergunta, String CaminhoGabarito){
        
        if (flagLeitor == false) {
            try {
                brPergunta = new BufferedReader(new FileReader(CaminhoPergunta));
                brGabarito = new BufferedReader(new FileReader(CaminhoGabarito));
                flagLeitor = true;
            } catch (IOException e) {
                System.err.println("Erro ao abrir: " + e.getMessage());
            }
        }
         if (brPergunta == null && brGabarito == null) {
            try {
                brPergunta.close();
                brGabarito.close();
                Enunciado = null;
                Gabarito = null;
                flagLeitor = false;
            } catch (IOException e) {
                System.err.println("Erro ao fechar: " + e.getMessage());
            }
        } 

        try {
            this.Enunciado = brPergunta.readLine();
            this.Gabarito = brGabarito.readLine();
        } catch (IOException e) {
            System.err.println("Erro ao ler: " + e.getMessage());
        }


    
    }


}