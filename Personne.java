
public class Personne {
      private String CIN;
      private String Nom;
      private String Prenom;
      private Adresse adress;
  
  public Personne ( String cin, String nom, String prenom, Adresse adress) {
        this.CIN= cin;
        this.Nom= nom;
        this.Prenom= prenom;
        this.adress= adress;
  }
  
  public Personne (String cin, String nom, String prenom, String governorat, int codepost) {
        this.CIN= cin;
        this.Nom= nom;
        this.Prenom= prenom;   
        this.adress= new Adresse( governorat, codepost);
 }
  

public String getCin(){
     return(this.CIN);
 }

public String getNom(){
     return(this.Nom);
 }

public String getPrenom(){
     return(this.Prenom);
 }
 
public Adresse getAdresse(){
     return(this.adress);
}

public void setCin(String c){
        this.CIN= c;    
}

public void setNom(String nom){
      this.Nom= nom;
}

public void setPrenom( String prenom) {
       this.Prenom= prenom;
}

public void setAdresse( Adresse a) {
       this.adress= a;
}

public String toString() {
     return ("CIN :"+ this.CIN + "Nom :"+ this.Nom + "Prenom :"+ this.Prenom +"Adresse :"+ this.adress);
}
}
