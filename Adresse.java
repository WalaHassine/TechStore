

public class Adresse {
       private int codepost;
       private String governorat;

   public Adresse ( String gov,int code){
          this.codepost= code;
          this.governorat= gov;
   }
 
   public String getGovernorat(){
         return (this.governorat);
   }
   
   public int getCodepostal(){
         return (this.codepost);
   }

   public void setGovernorat( String ch) {
         this.governorat= ch;
   }

   public void setCodepostal (int c) {
         this.codepost= c;
   }
  
   public String toString(){
          return ("Adresse:[ code postal: "+ this.codepost +" Governorat: "+ this.governorat + "]");
   }
}