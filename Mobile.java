public class Mobile extends AppareilInfo{
    private Double appareilPhotoFrontale;
    private Double appareilPhotoArriere;
    private int nbSim;
    private long capaciteBatterie;

    public Mobile(String nomArt, double px,double reso, String process, Long ram, SystemExploite sys, double appareilFrontale, double appareilArriere, int nbSim, long capaciteBatterie){
        super(nomArt,px,reso, process,ram, sys);
        this.appareilPhotoFrontale=appareilFrontale;
        this.appareilPhotoArriere= appareilArriere;
        this.nbSim= nbSim;
        this.capaciteBatterie=capaciteBatterie;
    }
    public void setAppareilPhotoFrontale(double appfrontale){
        appareilPhotoFrontale= appfrontale;
    }
    public void setAppareilPhotoArriere(double apparriere){
        appareilPhotoArriere=apparriere;
    }
    public void setNBsim(int nb){
        this.nbSim= nb;
    }
    public void setCapaciteBatterie( long cap){
        capaciteBatterie= cap;
    }
    public double getAppareilPhotoFrontale(){
        return this.appareilPhotoFrontale;
    }
    public double getAppareilPhotoArriere(){
        return this.appareilPhotoArriere;
    }
    public int getNBsim(){
        return this.nbSim;
    }
    public long getCapaciteBatterie(){
        return this.nbSim;
    }
    @Override
    public String toString(){
        return( "Mobile [ Appareil photo frontale: "+this.appareilPhotoFrontale+" Appareil photo Arriere: "+ this.appareilPhotoArriere+" nombre de Sim:  "+ this.nbSim+"capacite de batterie: "+ this.capaciteBatterie+"]");

    }
}
