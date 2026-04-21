public class Inimigos extends Personagem {
    String[] Dialogos = new String[10];

    public Inimigos(int Vida, int Dano, int Defesa, String Nome){
        super(Vida, Dano, Defesa, 0, Nome);
    
        
    }       
    
    public String[] getDialogos(){
        return this.Dialogos;
    }

    public void setDialogos(String[] Dialogos){
        this.Dialogos = Dialogos;
    }
}
