public class Tank extends Personagem implements HabilidadeEspecial {

    public Tank(){
        super(250, 20, 10, 0, "Tank");
        // Tank possui mais vida e defesa, mas menos dano. (Valores a ser definidos posteriormente)
    }
    
    @Override
    public String getNomeHabilidade() { 
        return "fortalecer"; 
    }

    @Override
    public String getDescricaoHabilidade() { 
        return "- Fortalecer (Custo: 3 QI) - Aumenta a defesa em 50% para a próxima rodada"; 
    }

    @Override
    public int getCustoQI() { 
        return 3; 
    }

    @Override
    public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
        // Calcula a nova defesa com 50% de bônus
        int novaDefesa = (int) (this.getDefesa() * 1.5);
        
        // Atualiza a defesa no BattleManager para esta rodada
        manager.setDefesaTotal(novaDefesa); 
        
        // Deduz o custo de QI
        this.setQI(this.getQI() - getCustoQI());
        
        System.out.println("Você usou Fortalecer! Sua defesa aumentou para " + novaDefesa + " nesta rodada.");
    }
}
