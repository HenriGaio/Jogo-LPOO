public class Inimigos extends Personagem {
    String[] Dialogos = new String[10];

    public Inimigos(int Vida, int Dano, int Defesa, String Nome)	 { super(Vida, Dano, Defesa, 0, Nome); } // O número zero é o QI (mana do inimigo)      
    public String[] getDialogos()								 	 { return this.Dialogos;} // Os diálogos ainda não foram implementados, ficarão aqui para caso façamos uma UI
    public void setDialogos(String[] Dialogos)						 { this.Dialogos = Dialogos;}
}
