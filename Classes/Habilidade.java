public class Habilidade{
    
    public void Eliminar(PerguntaMultiplaEscolha pergunta){
        int ParametroA = pergunta.GetterEnunciado().indexOf(".", pergunta.GetterEnunciado().indexOf("a)"));
        int ParametroB = pergunta.GetterEnunciado().indexOf(".", pergunta.GetterEnunciado().indexOf("b)"));
        
        

        String AlternativaA = pergunta.GetterEnunciado().substring(pergunta.GetterEnunciado().indexOf("a)"), ParametroA);
        String AlternativaB = pergunta.GetterEnunciado().substring(pergunta.GetterEnunciado().indexOf("b)"), ParametroB);
        
        

        
        if(!pergunta.GetterGabarito().equals(AlternativaA)){
            pergunta.SetterEnunciado(pergunta.GetterEnunciado().replace("\n" + AlternativaA + ".", ""));
        }
        else if(!pergunta.GetterGabarito().equals(AlternativaB)){
            pergunta.SetterEnunciado(pergunta.GetterEnunciado().replace("\n" + AlternativaB + ".", ""));
        }
        

    }
}    