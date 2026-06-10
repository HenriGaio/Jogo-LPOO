public class Estrategista extends Personagem implements HabilidadeEspecial {
    public Estrategista(){
        super(200, 10, 5, 0, "Estrategista");
        // Estrategista ganha o dobro de QI por rodada, mas tem menos vida, dano e defesa. (Valores a ser definidos posteriormente).
        
    }
    
    @Override
    public String getNomeHabilidade() { return "eliminar"; }

    @Override
    public String getDescricaoHabilidade() { return "- Eliminar (Custo: 2 QI) - Elimina uma alternativa errada"; }

    @Override
    public int getCustoQI() { return 2; }

    @Override
    public void executarHabilidade(BattleManager manager, Pergunta pergunta) {
        if (pergunta instanceof PerguntaMultiplaEscolha) {
            int ParametroA = pergunta.getEnunciado().indexOf(" ", pergunta.getEnunciado().indexOf("a)"));
        	int ParametroB = pergunta.getEnunciado().indexOf(" ", pergunta.getEnunciado().indexOf("b)"));
        	
        	
	
        	String AlternativaA = pergunta.getEnunciado().substring(pergunta.getEnunciado().indexOf("a)"), ParametroA);
        	String AlternativaB = pergunta.getEnunciado().substring(pergunta.getEnunciado().indexOf("b)"), ParametroB);
        	
        	
	
        	
        	if(!pergunta.getGabarito().equals(AlternativaA)){
            	pergunta.setEnunciado(pergunta.getEnunciado().replace("\n" + AlternativaA + " ", ""));
        	}
        	else if(!pergunta.getGabarito().equals(AlternativaB)){
            	pergunta.setEnunciado(pergunta.getEnunciado().replace("\n" + AlternativaB + " ", ""));
        	}
            	this.setQI(this.getQI() - getCustoQI());
            	System.out.println("Você usou Eliminar!");
        	}
    }
}
