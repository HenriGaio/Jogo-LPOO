public class PerguntaMultiplaEscolha extends Pergunta {
    public String GetterEnunciado() {
        return this.Enunciado;
    }

    public String GetterGabarito() {
        return this.Gabarito;
    }


    @Override
    public void AtualizarPergunta(String caminhoPergunta, String caminhoGabarito) {
        
        super.AtualizarPergunta(caminhoPergunta, caminhoGabarito);
        if (this.GetterEnunciado() != null) {
            this.Enunciado = this.GetterEnunciado().replace("  ", "\n");
        }
    }
}
