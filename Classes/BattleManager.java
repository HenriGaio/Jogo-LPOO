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

    } else if(this.Escolha.equals("habilidades")){
        System.out.println("Escolha uma habilidade:");
        
        if (Jogador instanceof Estrategista) {
            System.out.println("- Eliminar (Custo: 2 QI) - Elimina uma alternativa errada (apenas para perguntas de múltipla escolha)");
        } if (Jogador instanceof Combatente) {
            System.out.println("- Crítico (Custo: 3 QI) - Aumenta o dano do próximo ataque em 50%");
        } else if (Jogador instanceof Tank) {
            System.out.println("- Fortalecer (Custo: 3 QI) - Aumenta a defesa em 50% para a próxima rodada");
        }
        
        System.out.print("Opção: ");
        Resposta = Leitor.nextLine().toLowerCase().trim();
        
        // Loop de validação para forçar o usuário a digitar o nome da habilidade corretamente
        while (true) {
            if (Jogador instanceof Estrategista && Resposta.equals("eliminar")) break;
            if (Jogador instanceof Combatente && (Resposta.equals("critico") || Resposta.equals("crítico"))) break;
            if (Jogador instanceof Tank && Resposta.equals("fortalecer")) break;
            
            System.out.print("Habilidade inválida! Digite o nome da habilidade mostrada acima: ");
            Resposta = Leitor.nextLine().toLowerCase().trim();
        }
        
        // Processamento das habilidades
        if(Resposta.toLowerCase().equals("eliminar") && Jogador.getQI() >= 2 && Pergunta instanceof PerguntaMultiplaEscolha && Jogador instanceof Estrategista){
            Jogador.getHabilidades().Eliminar((PerguntaMultiplaEscolha) Pergunta);
            Jogador.setQI(Jogador.getQI() - 2);
        }
        else if (Resposta.toLowerCase().equals("critico") && Jogador.getQI() >= 3 && Jogador instanceof Combatente){
            ataqueTotal = (int) Jogador.getHabilidades().Critico(Jogador);
            Jogador.setQI(Jogador.getQI() - 3);
        }
        else if (Resposta.toLowerCase().equals("fortalecer") && Jogador.getQI() >= 3 && Jogador instanceof Tank){
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
            
            

