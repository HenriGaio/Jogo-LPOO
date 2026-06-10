import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    private String Nome;
    private int Vida;
    private int Dano;
    private int Defesa;
    private int QI;
    private List<HabilidadeEspecial> habilidades = new ArrayList<>();

    public Personagem(int Vida, int Dano, int Defesa, int QI, String Nome){
        this.Vida = Vida;
        this.Dano = Dano;
        this.Defesa = Defesa;
        this.QI = QI;
        this.Nome = Nome;
    }

    // Registra uma habilidade na lista do personagem, habilidades estas que serão registradas nas classes dos tipos de personagem
    protected void adicionarHabilidade(HabilidadeEspecial hab) { this.habilidades.add(hab); }

    public List<HabilidadeEspecial> getHabilidades() { return this.habilidades; }

    public int getVida()         { return this.Vida; }
    public void setVida(int v)   { this.Vida = v; }
    public int getDano()         { return this.Dano; }
    public int getDefesa()       { return this.Defesa; }
    public int getQI()           { return this.QI; }
    public void setQI(int QI)    { this.QI = QI; }
    public String getNome()      { return this.Nome; }
    public boolean estaVivo()    { return this.Vida > 0; }
}
