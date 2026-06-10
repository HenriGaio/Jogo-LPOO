public class Estrategista extends Personagem {

    public Estrategista() {
        super(200, 10, 5, 0, "Estrategista");

        // Habilidade 1: Eliminar
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "eliminar"; }
            @Override public String getDescricaoHabilidade() { return "- Eliminar (Custo: 2 QI) - Elimina uma alternativa errada"; }
            @Override public int getCustoQI() { return 2; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
                if (pergunta instanceof PerguntaMultiplaEscolha) {
                    int paramA = pergunta.getEnunciado().indexOf(" ", pergunta.getEnunciado().indexOf("a)"));
                    int paramB = pergunta.getEnunciado().indexOf(" ", pergunta.getEnunciado().indexOf("b)"));
                    String altA = pergunta.getEnunciado().substring(pergunta.getEnunciado().indexOf("a)"), paramA);
                    String altB = pergunta.getEnunciado().substring(pergunta.getEnunciado().indexOf("b)"), paramB);
                    if (!pergunta.getGabarito().equals(altA))
                        pergunta.setEnunciado(pergunta.getEnunciado().replace("\n" + altA + " ", ""));
                    else if (!pergunta.getGabarito().equals(altB))
                        pergunta.setEnunciado(pergunta.getEnunciado().replace("\n" + altB + " ", ""));
                    setQI(getQI() - getCustoQI());
                    System.out.println("Você usou Eliminar!");
                } else {
                    System.out.println("Eliminar só funciona em perguntas de múltipla escolha!");
                }
            }
        });

        // Habilidade 2: Analisar
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "analisar"; }
            @Override public String getDescricaoHabilidade() { return "- Analisar (Custo: 4 QI) - Revela a primeira letra do gabarito"; }
            @Override public int getCustoQI() { return 4; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
            	if (pergunta instanceof PerguntaFillTheBlank) {
                System.out.println("Dica: a resposta começa com '" + pergunta.getGabarito().charAt(0) + "'");
                setQI(getQI() - getCustoQI());
            	} else {
            		System.out.println("Analisar só funciona em perguntas Fill the blank");
            	}
            }
        });
    }
}
