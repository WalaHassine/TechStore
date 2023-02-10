
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Client extends Personne{
    private ArrayList<Element> panier;
    private static int idFacture=0;
    double genererFacture(){
        double total=0;
        String facture ="Article \t Quantite \t Prix unitaire \n";
        String path = "/home/marwa/eclipse-workspace/TechStore/factures/";
        String file = path + "Facture_" + idFacture + ".txt";
    for (Element e : getPanier()) {
        total += e.getPrixArticle() * e.getQuantite();
        facture += e.getReferenceArticle() + " \t \t \t " +e.getQuantite()+ "\t\t\t" + e.getPrixArticle() + " \n"; 
    }
        facture += "\n_________________________________________________\n \t \t \t Total: \t" + total;
        BufferedWriter br;
    try {
     br = new BufferedWriter(new FileWriter(file));
     br.write(facture + "\n \n");
     br.close();
      } 
    catch (IOException e) { 
    e.printStackTrace(); 
      }
    idFacture++;
    return total;
    }
    
    public Client(ArrayList<Element> panier,String cin, String nom, String prenom, Adresse adress ){
        super(cin,nom,prenom,adress);
        this.panier=panier;

    }
    public Client(String cin, String nom, String prenom, Adresse adress){
        super(cin,nom,prenom,adress);
        this.panier= new ArrayList<Element>();

    }

    public void setPanier(ArrayList<Element> pan){
        this.panier=pan;
    }
     public ArrayList<Element> getPanier(){
        return this.panier;
     }
    
     public Element trouverArticle(String reff){
        for(Element objet: panier){
            if(objet.getReferenceArticle().equals(reff)){
                return objet ;
            }
        }
        return null;
     }

     public void ajouterAuPanier(Stock stock,String reff,long quant){
            Element e =this.trouverArticle(reff);
            if( e !=null){
                e.incrementerQuantite(quant);
            }

            Element elemo = stock.trouverArticle(reff);
            elemo.setQuantite(quant);
            this.panier.add(elemo);
     }

     public void mettreAjourQuantite(String reff,long quant){
          Element e= this.trouverArticle(reff);
          if(e!=null){
          e.setQuantite(quant);
          }
        }

     public void supprimerArticle(String reff){
        Element e =this.trouverArticle(reff);
        if(e!=null){
            this.getPanier().remove(e);
           }
    
     }

     
     public void annulerCommande(){
        
        for(Element e :panier){
            supprimerArticle(e.getReferenceArticle());
        }

     }

      /*version 2 de methode annulerCommande
       * public void annulerCommande(){
       *       for (Element obj: panier){
       *            this.getPanier().remove(obj);
       *       }
       * }
       */
      /*version 3 de methode annulerCommande
       * public void annulerCommande(){
       * panier.clear();
       * }
       */
    @Override
      public String toString() {
        String toutLePanier="Client ["+super.toString()+"]\n";
        for (int i = 0; i < panier.size(); i++)
        toutLePanier+=panier.get(i).toString()+" \n ";
        return toutLePanier;
        }
    
        public void afficherMonPanier() {
            System.out.println(toString());

        }
    

    public void finaliserCommande(Stock stock){
        double total = genererFacture();
        System.out.println("Le total de vos achats est " + total);
        panier.clear();

    }
    void afficherStockCroissant(Stock stock) {
        stock.afficherCroissant();
        }
        void afficherStockDecroissant(Stock stock) {
        stock.afficherDecroissant();
        }

     
}
