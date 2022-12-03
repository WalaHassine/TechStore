
public class Peripheriques extends Article{
    private String technologieDeConnexion;
    private String interfaceAvecOrdinateur;

    public Peripheriques(String nomArt, Double px, String tech,String inter){
        super(nomArt,px);
        technologieDeConnexion= tech;
        interfaceAvecOrdinateur=inter;
    }
    public void setTechnologie(String tech){
        technologieDeConnexion=tech;
    }
    public void setInterface(String inter){
        interfaceAvecOrdinateur=inter;
    }
    public String getTecchnologie(){
        return this.technologieDeConnexion;
    }
    public String getInterface(){
        return this.interfaceAvecOrdinateur;
    }
    @Override
    public String toString(){
        return ("Peripherique [ technologie de connexion: "+ this.technologieDeConnexion+" interface avec ordinateur: "+this.interfaceAvecOrdinateur);
    }

}