public abstract class Ordinateur extends AppareilInfo {
    private long disqueDur;
    private String carteGraphique;
    public Ordinateur(String nomArt,Double px ,double reso, String process, Long ram, SystemExploite sys,long disque,String carte){
        super( nomArt, px , reso, process, ram,sys);
        disqueDur=disque;
        carteGraphique=carte;
    }
    public void setDisqueDur(long disque){
        disqueDur=disque;
    }
    public void setCarteGraphique(String carte){
        carteGraphique=carte;
    }
    public long getDisqueDur(){
        return this.disqueDur;
    }
    public String getCarteGraphique(){
        return this.carteGraphique;
    }
    public String toString(){
        return("Ordinateur [ disque dur :"+ this.disqueDur+" carte graphique: "+ this.carteGraphique+"]");
    }
}
