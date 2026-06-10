public class Combatente extends Personagem {

    public Combatente() {
        super(150, 30, 2, 0, "Combatente");

        // Habilidade 1: Crítico
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "critico"; }
            @Override public String getDescricaoHabilidade() { return "- Crítico (Custo: 3 QI) - Aumenta o dano do próximo ataque em 50%"; }
            @Override public int getCustoQI() { return 3; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
                int novoAtaque = (int) (getDano() * 1.5);
                manager.setAtaqueTotal(novoAtaque);
                setQI(getQI() - getCustoQI());
                System.out.println("Você usou Crítico! Seu ataque aumentou para " + novoAtaque + " nesta rodada.");
            }
        });

        // Habilidade 2: Fúria 
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "furia"; }
            @Override public String getDescricaoHabilidade() { return "- Fúria (Custo: 5 QI) - Dobra o dano do próximo ataque"; }
            @Override public int getCustoQI() { return 5; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
                int novoAtaque = getDano() * 2;
                manager.setAtaqueTotal(novoAtaque);
                setQI(getQI() - getCustoQI());
                System.out.println("Você usou Fúria! Seu ataque dobrou para " + novoAtaque + " nesta rodada.");
            }
        });
    }
}
