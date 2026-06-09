public class Habilidade{
    

    public void Eliminar(PerguntaMultiplaEscolha pergunta){
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
   

    }

    public int Critico(Personagem Jogador){
        return (int) (Jogador.getDano() * 1.5);
    }

    public int Fortalecer(Personagem Jogador){
        return (int) (Jogador.getDefesa() * 1.5);
    }

}