

public abstract class AppareilInfo extends Article {
  public enum SystemExploite{
    FreeDos, Windows, Ubuntu, Android, IOS

}
  private Double resolutionEcran;
  private String processeur;
  private Long ram;
  private SystemExploite SystemExploite;

  public AppareilInfo(String nomArt,Double px ,double reso, String process, Long ram, SystemExploite sys){
    super(nomArt, px);
    this.resolutionEcran= reso;
    this.processeur= process;
    this.ram= ram;
    this.SystemExploite= sys ;
  }

  public Double getResolution(){
    return this.resolutionEcran;
  }
  public String getProcesseur(){
    return this.processeur;
  }
  public Long getRam(){
    return this.ram;
  }
  public SystemExploite getSystem(){
    return this.SystemExploite;
  }
  public void setResolution(double reso){
    this.resolutionEcran= reso;
  }
  public void setProcesseur(String process){
    this.processeur= process;
  }
  public void setRam(Long ram){
    this.ram= ram;
  }
  public void setSystemeExploite(SystemExploite SystemExploite){
    this.SystemExploite= SystemExploite;
  }
  @Override
  public String toString(){
    return ("Appareil Informatique[ resolution: "+ this.resolutionEcran+" processeur: "+this.processeur+"Ram: "+ this.ram+"systeme d'exploitaton: "+this.SystemExploite)+"]";
  }
  
}

