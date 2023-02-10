public abstract class Administration extends Personne {
 private Stock stock;
 
 public Administration(String cin, String nom, String prenom, Adresse adress){
    super(cin, nom, prenom, adress);
    this.stock= new Stock();
  }
 public Administration(String cin, String nom, String prenom, Adresse adress, Stock s){
    super(cin, nom, prenom, adress);
    stock=s;
 }

 public void setStock(Stock s){
    stock=s;
 }
 public Stock getStock(){
    return stock;
 }

 public void AjouterArticle(String nom, double prix, double res, long ram, long disqueDur,String processeur, String cartegraphique,AppareilInfo.SystemExploite sys,String alimentation,long quantArt){
       this.stock.AjouterArticle(nom,prix,res,ram,disqueDur,processeur,cartegraphique, sys,alimentation,quantArt);
}
public void AjouterArticle(String nom, double prix, double res, long ram, long disqueDur,String processeur, String cartegraphique,AppareilInfo.SystemExploite sys,long cap,long quantArt){
       this.stock.AjouterArticle(nom,prix,res,ram,disqueDur,processeur,cartegraphique, sys,cap,quantArt);
}
public void AjouterArticle(String nomArt, double px,double reso, String process, Long ram, AppareilInfo.SystemExploite sys, double appareilFrontale, double appareilArriere, int nbSim, long capaciteBatterie, long quantArt){
    this.stock.AjouterArticle(nomArt, px, reso, process, ram, sys, appareilFrontale, appareilArriere, nbSim, capaciteBatterie, quantArt);
}
public void AjouterArticle(String nomArt,Double px,int cap, long quantArt){
    this.stock.AjouterArticle(nomArt, px, cap, quantArt);
}
public void AjouterArticle(String nomArt, Double px, String tech,String inter, long quantArt){
   this.stock.AjouterArticle(nomArt, px, tech, inter, quantArt);
}

public void ModifierArticle(String reff, String nom,Double prix,Long quant){
   stock.ModifierArticle(reff, nom, prix, quant);
}

public void SupprimerArticle(String reff){
   stock.SupprimerArticle(reff);
}
public String AfficherArticle(){
   return stock.toString();
}
@Override
public String toString(){
   return("");
}
}
