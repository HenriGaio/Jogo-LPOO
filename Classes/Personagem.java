public class Personagem {
    private int Vida;
    private int Dano;
    private int Defesa;
    private int QI;
    private Habilidade Habilidades = new Habilidade();
    
    public int GetterVida(){
        return this.Vida;

    }
    public void SetterVida(int Vida){
        this.Vida = Vida;
    }
    public int GetterDano(){
        return this.Dano;
    }
    public int GetterQI(){
        return this.QI;
    }
    public Habilidade GetterHabiliadades(){
        return this.Habilidades;
    }
    public int GetterDefesa(){
        return this.Defesa;
    }
}
