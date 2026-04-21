public class PerguntaCertoOuErrado extends Pergunta {
    @Override
    public void atualizarPergunta(String caminhoPergunta, String caminhoGabarito) {
        super.atualizarPergunta(caminhoPergunta, caminhoGabarito);
        if (this.getEnunciado() != null) {
            this.Enunciado = this.getEnunciado().replace("  ", "\n");
        }
    }
}
