public class PerguntaCertoOuErrado extends Pergunta {
    @Override
    public void AtualizarPergunta(String caminhoPergunta, String caminhoGabarito) {
        super.AtualizarPergunta(caminhoPergunta, caminhoGabarito);
        if (this.getEnunciado() != null) {
            this.Enunciado = this.getEnunciado().replace("  ", "\n");
        }
    }
}