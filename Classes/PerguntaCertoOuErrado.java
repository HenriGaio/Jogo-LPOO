public class PerguntaCertoOuErrado extends Pergunta {
    @Override
    public void AtualizarPergunta(String caminhoPergunta, String caminhoGabarito) {
        super.AtualizarPergunta(caminhoPergunta, caminhoGabarito);
        if (this.GetterEnunciado() != null) {
            this.Enunciado = this.GetterEnunciado().replace("  ", "\n");
        }
    }
}