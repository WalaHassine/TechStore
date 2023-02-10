public class ComposantStockage extends Article{
    private int capacite;

    public ComposantStockage(String nomArt,Double px,int cap){
        super(nomArt,px);
        capacite=cap;
    }
    
    public void setCapacite(int cap){
        capacite=cap;
    }
    public int getCapacite(){
        return this.capacite;
    }
    
    @Override
    public String toString(){
        return("composant de stockage [ capacite ="+this.capacite+"]");
    }
}