import java.util.ArrayList;

public class Stock{
    private ArrayList <Element> ArticleList;
    public Stock(){
        this.ArticleList= new ArrayList<Element>();
    }
    public Stock(ArrayList <Element> List){
        this.ArticleList= List;
    }
    public Stock(ArrayList <String> n, ArrayList <Double> px, ArrayList <Long> quan){
        int i;
        this.ArticleList= new ArrayList<Element>();
        for (i=0;i<n.size();i++){
             this.ArticleList.add(new Element(n.get(i),px.get(i) , quan.get(i)));
        }
    }
    public ArrayList<Element> getArticleList(){
        return this.ArticleList;
    }
    public int getNB(){
        return this.ArticleList.size();
    }
    public void setArticle(ArrayList<Element> A){
        this.ArticleList= A;
    }
    public  void AjouterArticle(Article Arti, long Qu){
        this.ArticleList.add(new Element(Arti, Qu));

    }
    public void AjouterArticle(String nom,double prix,long quantite){
        Article A= new Article(nom,prix);
        this.AjouterArticle(A, quantite);
    }
    public  void AjouterArticle(String nom, Double prix, Double res, long ram, long disqueDur,String processeur, String cartegraphique,AppareilInfo.SystemExploite sys,String alimentation,long quantArt){
        Article A= new OrdinateurBureau(nom,prix, res, processeur,ram, sys, disqueDur, cartegraphique, alimentation);
        AjouterArticle(A, quantArt);
    }
    public void AjouterArticle(String nom, double prix, double res, long ram, long disqueDur,String processeur, String cartegraphique,AppareilInfo.SystemExploite sys,long cap,long quantArt){
        Article A= new OrdinateurPortable(nom, prix, res, processeur, ram, sys, disqueDur, cartegraphique, cap);
        AjouterArticle(A, quantArt);
    }
    public void AjouterArticle(String nomArt, double px,double reso, String process, Long ram, AppareilInfo.SystemExploite sys, double appareilFrontale, double appareilArriere, int nbSim, long capaciteBatterie, long quantArt){
        Article A= new Mobile(nomArt, px, reso, process, ram, sys, appareilFrontale, appareilArriere, nbSim, capaciteBatterie);
        AjouterArticle(A, quantArt);;
    }
    public void AjouterArticle(String nomArt,Double px,int cap, long quantArt){
        Article A = new ComposantStockage(nomArt, px, cap);
        AjouterArticle(A, quantArt);
    }
    public void AjouterArticle(String nomArt, Double px, String tech,String inter, long quantArt){
        Article A= new Peripheriques(nomArt, px, tech, inter);
        AjouterArticle(A, quantArt);
    }
    
    public Element TrouverArticle(String reff){
          int i=0;
           while((i<getNB())&& (!this.getArticleList().get(i).equals(reff))){
            i++;
            if(i<this.getNB()){
                return this.ArticleList.get(i);
            }
            else{
                return null;
            }
           }
        }

    
    public void ModifierArticle(String reff, String nom,double prix,long quantite){
        int i;
        for(i=0;i<this.ArticleList.size();i++){ // parcours de toute la liste
            if(this.ArticleList.get(i).equals(reff)){ // on prend la reference comme conditon pour la modification
               this.ArticleList.get(i).Modifier(nom,prix); // on appel la fonction Modifier de class article 
            }
        }
    }
   /*  public void SupprimerArticle(string reff){
        ArrayList<Element> ArticleList = new ArrayList<Element>(); //on a creé une autre liste
        for(i=0;i<this.ArticleList.size();i++){
            if(!this.ArticleList.get(i).equals(reff)){ // si la reference est differente de celle a supprimer
               ArticleList.add(this.ArticleList(get(i))); // on l'ajoute dans cette nouvelle liste
            }
        }
    this.ArticleList=ArticleList ;  //on effectue la nouvelle liste comme la liste de debut( originale)
    } */

    public void SupprimerArticle(String reff){
        Element E= TrouverArticle(reff);
        if (E!= null){
            this.getArticleList().remove(E);
        }
    }
    public void  incrementerQuantiteArticle(String reff,long quantite){
        int i;
        for(i=0;i<this.ArticleList.size();i++){ // parcours de toute la liste
            if(this.ArticleList.get(i).equals(reff)){
                this.ArticleList.get(i).incrementerQuantite(quantite);

            }
        }
    }
    public void decrementerQuantiteArticle(String reff, long quantite){
        int i;
        for(i=0;i<this.ArticleList.size();i++){ 
            if(this.ArticleList.get(i).equals(reff)){
                this.ArticleList.get(i).decrementerQuantite(quantite);
            }
        }
    }
    

    public String toString(){
        String res="";
        int i;
        for(i=0;i<this.ArticleList.size();i++){ // parcours de toute la liste
           res+= this.ArticleList.get(i)+ "\n";
    }
    return res;
  }
}

