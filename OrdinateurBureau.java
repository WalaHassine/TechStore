public class OrdinateurBureau extends Ordinateur{
  private String alimentaion;
  
  public OrdinateurBureau(String nomArt,Double px ,double reso, String process, Long ram, SystemExploite sys,long disque,String carte,String alim){
    super(nomArt, px, reso, process, ram, sys, disque, carte);
    alimentaion=alim;
  }
  
  public void setAlim(String alim){
    alimentaion=alim;
  }
  public String getAlim(){
    return alimentaion;
  }

  @Override
  public String toString(){
    return("Ordinateur Bureau [ Alimentaion ="+ this.alimentaion+"]");
  }
}