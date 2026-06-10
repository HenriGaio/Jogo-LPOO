public class Tank extends Personagem {

    public Tank() {
        super(250, 20, 10, 0, "Tank");

        // Habilidade 1: Fortalecer
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "fortalecer"; }
            @Override public String getDescricaoHabilidade() { return "- Fortalecer (Custo: 3 QI) - Aumenta a defesa em 50% para a próxima rodada"; }
            @Override public int getCustoQI() { return 3; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
                int novaDefesa = (int) (getDefesa() * 1.5);
                manager.setDefesaTotal(novaDefesa);
                setQI(getQI() - getCustoQI());
                System.out.println("Você usou Fortalecer! Sua defesa aumentou para " + novaDefesa + " nesta rodada.");
            }
        });

        // Habilidade 2: Barreira
        adicionarHabilidade(new HabilidadeEspecial() {
            @Override public String getNomeHabilidade() { return "barreira"; }
            @Override public String getDescricaoHabilidade() { return "- Barreira (Custo: 6 QI) - Bloqueia todo o dano na próxima defesa"; }
            @Override public int getCustoQI() { return 6; }
            @Override public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
                manager.setDefesaTotal(9999);
                setQI(getQI() - getCustoQI());
                System.out.println("Você usou Barreira! Você bloqueará todo o dano ao defender nesta rodada.");
            }
        });
    }
}
