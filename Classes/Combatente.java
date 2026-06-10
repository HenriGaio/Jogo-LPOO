public class Combatente extends Personagem implements HabilidadeEspecial {
    
    public Combatente(){
        super(150, 30, 2, 0, "Combatente");
        // Combatente possui mais dano, mas menos vida e defesa. (Valores a ser definidos posteriormente)
    }
    @Override
    public String getNomeHabilidade() { 
        return "critico"; 
    }

    @Override
    public String getDescricaoHabilidade() { 
        return "- Crítico (Custo: 3 QI) - Aumenta o dano do próximo ataque em 50%"; 
    }

    @Override
    public int getCustoQI() { 
        return 3; 
    }

    @Override
    public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
        int novoAtaque = (int) (this.getDano() * 1.5);

        manager.setAtaqueTotal(novoAtaque); 

        this.setQI(this.getQI() - getCustoQI());
        
        System.out.println("Você usou Crítico! Seu ataque aumentou para " + novoAtaque + " nesta rodada.");
    }
}

