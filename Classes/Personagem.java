public abstract class Personagem {
    private String Nome;
    private int Vida;
    private int Dano;
    private int Defesa;
    private int QI;
    private Habilidade Habilidades = new Habilidade();
    
    public Personagem(int Vida, int Dano, int Defesa, int QI, String Nome){
        this.Vida = Vida;
        this.Dano = Dano;
        this.Defesa = Defesa;
        this.QI = QI;
        this.Nome = Nome;
    }
    
    
    public int getVida(){
        return this.Vida;

    }
    public void setVida(int Vida){
        this.Vida = Vida;
    }
    public void setQI(int QI){
        this.QI = QI;
    }

    public int getDano(){
        return this.Dano;
    }
    public int getQI(){
        return this.QI;
    }
    public Habilidade getHabilidades(){
        return this.Habilidades;
    }
    public int getDefesa(){
        return this.Defesa;
    }
    public String getNome(){
        return this.Nome;
    }
    
    public boolean estaVivo() {
        return this.Vida > 0;
    }
}
