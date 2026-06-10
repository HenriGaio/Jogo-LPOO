import java.util.Scanner;
import java.util.List;

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

	// Retorna true se a rodada deve avançar, false caso contrário
	public boolean Acao(Personagem Jogador, Personagem Inimigo, Pergunta Pergunta){
    	if (ataqueTotal == 0 && defesaTotal == 0) {
            ataqueTotal = Jogador.getDano();
            defesaTotal = Jogador.getDefesa();
        }

        if (this.Escolha.equals("responder")) {
            System.out.print("Digite sua resposta (Letra): ");
            this.Resposta = Leitor.nextLine().toLowerCase().trim();

            boolean acertou = false;
            if (Pergunta instanceof PerguntaFillTheBlank) {
                acertou = this.Resposta.equalsIgnoreCase(Pergunta.getGabarito().trim());
            } else {
                acertou = this.Resposta.length() > 0
                    && this.Resposta.charAt(0) == Pergunta.getGabarito().toLowerCase().charAt(0);
            }

            if (acertou) {
                Inimigo.setVida(Inimigo.getVida() - ataqueTotal);
                System.out.printf("Você acertou e causou %d de dano!\n", ataqueTotal);
                if (ataqueTotal != Jogador.getDano()) ataqueTotal = Jogador.getDano();
            } else {
                Jogador.setVida(Jogador.getVida() - Inimigo.getDano());
                System.out.printf("Você errou e recebeu %d de dano\n", Inimigo.getDano());
            }

            // Ganho de QI apenas ao responder
            if (Jogador.getQI() < 10) {
                Jogador.setQI(Jogador.getQI() + (Jogador instanceof Estrategista ? 2 : 1));
            }

            return true; // rodada avança

        } else if (this.Escolha.equals("defender")) {
            int danoRecebido = Inimigo.getDano() - defesaTotal;
            Jogador.setVida(Jogador.getVida() - danoRecebido);
            System.out.printf("Você defendeu e recebeu %d de dano\n", danoRecebido);
            if (defesaTotal != Jogador.getDefesa()) defesaTotal = Jogador.getDefesa();

            return true; // rodada avança

        } else if (this.Escolha.equals("habilidades")) {
            List<HabilidadeEspecial> habs = Jogador.getHabilidades();

            if (habs.isEmpty()) {
                System.out.println("Você não possui habilidades.");
                return false; // rodada NÃO avança
            }

            // Exibe todas as habilidades disponíveis
            System.out.println("Escolha uma habilidade (ou 'voltar' para cancelar):");
            for (HabilidadeEspecial h : habs) {
                System.out.println(h.getDescricaoHabilidade());
            }
            System.out.print("Opção: ");
            Resposta = Leitor.nextLine().toLowerCase().trim();

            if (Resposta.equals("voltar")) {
                System.out.println("Voltando ao menu de ações...");
                return false; // rodada NÃO avança
            }

            // Procura a habilidade digitada
            HabilidadeEspecial habEscolhida = null;
            for (HabilidadeEspecial h : habs) {
                if (h.getNomeHabilidade().equals(Resposta)) {
                    habEscolhida = h;
                    break;
                }
            }

            if (habEscolhida == null) {
                System.out.println("Habilidade inválida!");
                return false; // rodada NÃO avança
            }

            if (Jogador.getQI() >= habEscolhida.getCustoQI()) {
                habEscolhida.executarHabilidade(this, Pergunta);
                return false; // habilidade usada: rodada NÃO avança (jogador ainda responde/defende)
            } else {
                System.out.println("QI insuficiente! (Você tem " + Jogador.getQI() + " QI, precisa de " + habEscolhida.getCustoQI() + ")");
                return false; // rodada NÃO avança
            }
        }

        return false;
    }

}
            
            

