import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Stream;

public class QuestionManager {
    private Pergunta pergunta;
    private int ponteiro;
    private List<Integer> LinhasPergunta;
    private List<Integer> LinhasGabarito;
    private long linhas;
    
    public Pergunta getPergunta() {
        return pergunta;
    }
    
    
    public void AtualizarPergunta(String caminhoPergunta, String caminhoGabarito, Personagem inimigo) {
        
        if (ponteiro == 0) {
            
            try{
              LinhasPergunta = new java.util.ArrayList<>();
              LinhasGabarito = new java.util.ArrayList<>();
              this.linhas = Files.lines(Paths.get(caminhoPergunta)).count();
              
              
              for (int i = 0; i < linhas; i++) 
                  LinhasPergunta.add(i);
              
              Collections.shuffle(LinhasPergunta);
              this.LinhasGabarito = LinhasPergunta;
            
            }catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
            }  
         }
         
            try(Stream<String> streamPergunta = Files.lines(Paths.get(caminhoPergunta));
                Stream<String> streamGabarito = Files.lines(Paths.get(caminhoGabarito))){
                
                String linhaPergunta = streamPergunta.skip(LinhasPergunta.get(ponteiro)).findFirst().orElse(null);
                String linhaGabarito = streamGabarito.skip(LinhasGabarito.get(ponteiro)).findFirst().orElse(null);
                
                if (linhaPergunta != null && linhaPergunta.charAt(0) == 'M') {
                    this.pergunta = new PerguntaMultiplaEscolha();
                    this.pergunta.setEnunciado(linhaPergunta.replace("M|", "").replace("  ", "\n"));
                    this.pergunta.setGabarito(linhaGabarito.replace("  ", "\n"));
                    ponteiro++;
                } else if(linhaPergunta != null && linhaPergunta.charAt(0) == 'C') {
                    this.pergunta = new PerguntaCertoOuErrado();
                    this.pergunta.setEnunciado(linhaPergunta.replace("C|", "").replace("  ", "\n"));
                    this.pergunta.setGabarito(linhaGabarito.replace("  ", "\n"));
                    ponteiro++;
                } 

            } catch (IOException e) {
                System.out.println("Erro ao acessar o arquivo: " + e.getMessage()); 
                
            } 
        
        if (ponteiro == linhas-1 || !inimigo.estaVivo()){
            ponteiro = 0;
        }
        
    }
    
}
