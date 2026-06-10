public class Combatente extends Personagem {
	private static final int HP = 150;
	private static final int DANO = 30;
	private static final int DEFESA = 2;
	private static final int QI_INICIAL = 0;
	private static final String NOME = "Combatente";
	
    public Combatente() {
        super(HP, DANO, DEFESA, QI_INICIAL, NOME);
        
		/*Veja que aqui o parâmetro da função adicionarHabilidade é todo o bloco de código "new HabilidadeEspecial() {...}" 
		  ou seja, recebe como argumento um objeto que será adicionado na lista de habilidades do personagem. 
		  Lembrando que aqui ainda é dentro do construtor do personagem*/
		  
		
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
