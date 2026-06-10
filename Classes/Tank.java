public class Tank extends Personagem {
	private static final int HP = 250;
	private static final int DANO = 20;
	private static final int DEFESA = 10;
	private static final int QI_INICIAL = 0;
	private static final String NOME = "Tank";
	
    public Tank() {
        super(HP, DANO, DEFESA, QI_INICIAL, NOME);
        
		/*Veja que aqui o parâmetro da função adicionarHabilidade é todo o bloco de código "new HabilidadeEspecial() {...}" 
		  ou seja, recebe como argumento um objeto que será adicionado na lista de habilidades do personagem. 
		  Lembrando que aqui ainda é dentro do construtor do personagem*/
		  

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
