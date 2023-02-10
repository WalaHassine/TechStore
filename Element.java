public class Element{
    private Article art;
    private long quant;
    public Element( Article A,long Q){
        this.art=A;
        this.quant=Q;
    }
    public Element(String nom, double prix, long Q){
        art.setNom(nom);
        art.setPrix(prix);
        this.quant=Q;
    }
    public Article getArticle(){
         return(this.art);
    }
    public long getQuantite(){
        return(this.quant);
    }
    public String getReferenceArticle(){
        return(this.art.getReference());
    }
    public String getNomArticle(){
        return(this.art.getNom());
    }
    public Double getPrixArticle(){
        return(this.art.getPrix());
    }
    public void setArticle(Article A){
        this.art=A;
    }
    public void setQuantite(long Q){
        this.quant=Q;
    }
    public void incrementerQuantite(long plus){
        this.quant=getQuantite()+ plus;
    }
    public void decrementerQuantite(long moins){
        this.quant=getQuantite()- moins;
    }
    public void modifier(String m,Double px,long f){
        Article A= new Article(m,px);
        incrementerQuantite(f);
        this.art=A;
    }
    public boolean equals( String ref){
        
        if( this.art.getReference().equals(ref)){
            return true ;
        }
        else {
            return false;
        }
        }
    public boolean equals( Article art){
        if((art== null )||(art.getClass()!= this.art.getClass())){
             return false;
        }
        if (art.equals(art.getReference())){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return("Element[article"+ this.art+"quantite"+ this.quant);
    }
    }


    
    


