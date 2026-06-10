public interface HabilidadeEspecial {
    String getNomeHabilidade();
    String getDescricaoHabilidade();
    int getCustoQI();
    void executarHabilidade(BattleManager manager, Pergunta pergunta);
} 

/*Essa interface servirá como molde para criação de objetos (Habilidades Especiais) anônimos dentro das classes dos tipos de personagem
 (Combatente.java; Estrategista.java; Tank.java), pois as habilidades não precisam de atributos, apenas métodos para cálculo de dano e defesa*/
