public class Article{
    private int ID;
    private String Nom;
    private String Reference;
    private Double prix;
    private static int NextID;
    
    public Article(String nom, Double px){
           this.ID=NextID++;
           this.Nom=nom;
           this.prix=px;
    }
    
    public int getId(){
           return(ID);
    }
    public String getReference(){
           return(Reference);
    }
    public String getNom(){
           return(Nom);
    }
    public Double getPrix(){
           return(prix); 
    }
    
    public void setReference(String reff){
           this.Reference=reff;
   }
    public void setNom( String nom){
           this.Nom=nom;
   }
    public void setPrix(Double px){
           this.prix=px;
   }

   public void Modifier(String nom){
           this.Nom=nom;
           this.setReference(TechStore.GenererReference( nom,this.getId()));
   }
   public void Modifier (String nom, double px){
         if( !nom.equals(this.getNom())){
            this.Modifier(nom);
         }
         if (px!= this.getPrix()){
             this.setPrix(px);
         }
        this.setReference(TechStore.GenererReference( nom,this.getId()));
         }
   

   public String toString(){
    return("ID="+this.getId()+" nom="+ this.getNom()+" reference="+ this.getReference()+" prix="+ this.getPrix());
   }
}