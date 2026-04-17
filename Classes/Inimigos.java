public class Inimigos extends Personagem {
    String[] Dialogos = new String[10];

    public Inimigos(int Vida, int Dano, int Defesa, String Nome){
        super(Vida, Dano, Defesa, 0, Nome);
    
        
    }       
    
    public String[] GetterDialogos(){
        return this.Dialogos;
    }

    public void SetterDialogos(String[] Dialogos){
        this.Dialogos = Dialogos;
    }
}
