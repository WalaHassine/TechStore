
public class Test {
       public static void main(String [] args){
          Adresse a1 = new Adresse ("Monastir", 5000);
          Adresse a2 = new Adresse ("BenArous", 1133);
          
          Personne p1= new Personne ("01111111","kbayer","jasser","jandouba", 8160);
          Personne p2= new Personne ("02222222", "smida","ghayth",a2);
          
          p1.setPrenom("smida");
          p1.getPrenom();
          p1.setAdresse(a1);
          p1.getAdresse();
          p2.setPrenom("kbayer");
          p2.getPrenom();
          p2.setAdresse(p1.getAdresse());
          p2.getAdresse();
          System.out.println(p1.toString());

}
}
