public class OrdinateurPortable extends Ordinateur {
    private long capaciteBatterie;
    public OrdinateurPortable(String nomArt,double px ,double reso, String process, Long ram, SystemExploite sys,long disque,String carte,long capacite){
        super(nomArt, px , reso, process, ram,sys,disque,carte);
        capaciteBatterie=capacite;
    }
    public void setCapaciteBatterie(long cap){
        capaciteBatterie= cap;
    }
    public long getCapaciteBatterie(){
        return this.capaciteBatterie;
    }
    @Override
    public String toString(){
        return( "Ordinateur Portable [Capacite batterie ="+ this.capaciteBatterie+"]");
    }
    
}
