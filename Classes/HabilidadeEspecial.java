public interface HabilidadeEspecial {
    String getNomeHabilidade();
    String getDescricaoHabilidade();
    int getCustoQI();
    void executarHabilidade(BattleManager manager, Pergunta pergunta);
}
