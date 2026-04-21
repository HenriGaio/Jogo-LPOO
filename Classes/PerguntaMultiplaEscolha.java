public class PerguntaMultiplaEscolha extends Pergunta {
    public String getEnunciado() {
        return this.Enunciado;
    }

    public String getGabarito() {
        return this.Gabarito;
    }


    @Override
    public void AtualizarPergunta(String caminhoPergunta, String caminhoGabarito) {
        
        super.AtualizarPergunta(caminhoPergunta, caminhoGabarito);
        if (this.getEnunciado() != null) {
            this.Enunciado = this.getEnunciado().replace("  ", "\n");
        }
    }
}
