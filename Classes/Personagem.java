public abstract class Personagem {
    private int Vida;
    private int Dano;
    private int Defesa;
    private int QI;
    private Habilidade Habilidades = new Habilidade();
    
    public Personagem(int Vida, int Dano, int Defesa, int QI){
        this.Vida = Vida;
        this.Dano = Dano;
        this.Defesa = Defesa;
        this.QI = QI;
    }
    
    
    public int GetterVida(){
        return this.Vida;

    }
    public void SetterVida(int Vida){
        this.Vida = Vida;
    }
    public void SetterQI(int QI){
        this.QI = QI;
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
