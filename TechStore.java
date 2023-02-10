

import java.util.Scanner;
import java.util.ArrayList;

public class TechStore {

               //fonction pour generer les refernces des produits
            public static String GenererReference(String n,int id) {  
		        String reff="";
		        int i=0;
			     for(i=0;i<n.length();i+=5) {
				if(n.charAt(i) !=' ') {
					reff=reff+n.charAt(i)+id;
				}
			}
		             return(reff);
		}
               // fonction pour ajouter un article dans tableau des produits

	     public static void AjouterArticle(String n,Double p,ArrayList<Integer> ID,ArrayList<String> Reference,ArrayList<String> Nom,ArrayList<Double> Prix) {
		  int s;
			s=ID.size()+1;
			Prix.add(p);
			ID.add(s);
			Nom.add(n);
			Reference.add(GenererReference(n,s));
			}
               // fonction pour la modification d'un article

	    public static void ModifierArticle(Double np,String ref,ArrayList<Double> Prix,ArrayList<String> Reference) {
		int i=0;
			while((ref!=Reference.get(i))&&(i<Prix.size())) {
				i=i+1;
			}
			Prix.set(i, np); }
               // fonction pour l'affichage croissant des articles selon l'ordre croissant de prix

	public static void AffichageCroissant(ArrayList<Integer> ID,ArrayList<String> Reference,ArrayList<String> Nom,ArrayList<Double> Prix) {
             for(int i=0;i<Prix.size();i++)
            {
                for(int j=1; j < (Prix.size()-i); j++)
              {
                   if(Prix.get(j-1)>Prix.get(j))
                  {
                     double aux=Prix.get(j-1);
                     Prix.set(j-1,Prix.get(j));
                     Prix.set(j,aux);
                
                
                     int x=ID.get(j-1);
                     ID.set(j-1,ID.get(j));
                     ID.set(j,x);
                
                     String y=Reference.get(j-1);
                     Reference.set(j-1,Reference.get(j));
                     Reference.set(j,y);
                
                     String z=Nom.get(j-1);
                     Nom.set(j-1,Nom.get(j));
                     Nom.set(j,z);
                  }
             }
           }
        for(int i=1;i<Prix.size();i++)
          {
            System.out.println(ID.get(i)+" "+Reference.get(i)+" "+Nom.get(i)+" "+Prix.get(i));
          }
       }
        
            // fonction pour l'affichage decroissant des articles selon l'ordre croissant de prix

	public static void AffichageDecroissant(ArrayList<Integer> ID,ArrayList<String> Reference,ArrayList<String> Nom,ArrayList<Double> Prix) {
		
          for(int i=0;i<Prix.size();i++)
           {
            for(int j=1; j < (Prix.size()-i); j++)
             {
               if(Prix.get(j-1)<Prix.get(j))
                {
                  double aux=Prix.get(j-1);
                  Prix.set(j-1,Prix.get(j));
                  Prix.set(j,aux);
                
                
                  int x=ID.get(j-1);
                  ID.set(j-1,ID.get(j));
                  ID.set(j,x);
                
                  String y=Reference.get(j-1);
                  Reference.set(j-1,Reference.get(j));
                  Reference.set(j,y);
                
                  String z=Nom.get(j-1);
                  Nom.set(j-1,Nom.get(j));
                  Nom.set(j,z);
               }
            }
         }
        for(int i=1;i<Prix.size();i++)
        {
            System.out.println(ID.get(i)+" "+Reference.get(i)+" "+Nom.get(i)+" "+Prix.get(i));
        }
		
	}
 
          // fonction pour la suppression d'un article, on prend la reference d'article comme entree pour le test 

	public static void SupprimerArticle(String reff,ArrayList<Integer> ID,ArrayList<String> Reference,ArrayList<String> Nom,ArrayList<Double> Prix) {
		  int i=0;
			while((reff!=Reference.get(i))&&(i<Reference.size())) {
				i=i+1;
			}		
			Reference.remove(i);
			Prix.remove(i);
			Nom.remove(i);
			ID.remove(i);
	}
	



      public static void main( String [] args ){

		ArrayList<String> Nom = new ArrayList<String>();
		      ArrayList<Double> Prix = new ArrayList<Double>();
                 ArrayList<Long> quantite = new ArrayList<Long>();
                    Stock S = new Stock(Nom, Prix, quantite);
                    Client client=new Client(null, null, null, null, null);


       System.out.println("soyez les bienvenus!!");
	     System.out.println("0:Gerant"); 
	     System.out.println("1:Client");

             // l'entree differe selon l'utilisateur un gerant ou un client normal

             Scanner scanner = new Scanner ( System.in); 
             int perso = scanner.nextInt();

  if ( perso == 0){
        System.out.println("0: ajouter un article \n 1: augmenter la quantité d'un article \n 2: modifier un article \n 3: supprimer un article \n 4: consulter le stock \n 5: Quitter");
        int act=scanner.nextInt();
       
	  switch(act){
          
			case 0:{
        System.out.println("0: Ordinateur Bureau \n 1: Ordinateur Portable \n 2: Mobile \n 3: Stockage \n 4: Peripherique");
        int catego = scanner.nextInt();
         switch(catego){
          case 0:
          {
          System.out.println("donner les caracteristiques de l'odinateur bureau. nom,prix,resolution,ram,disque dur,processeur,carte graphique,alimentaion,quantite");
          
          String nom= scanner.next();
          Double prix= scanner.nextDouble();
          Double res= scanner.nextDouble();
          Long ram= scanner.nextLong();
          Long disqueDur= scanner.nextLong();
          String process= scanner.next();
          String carteGraphique= scanner.next();
          String alimentation=scanner.next();
          Long quantArt=scanner.nextLong();
          System.out.println("choisir un systeme d'exploitation: 0:FreeDos\n 1:Windows \n 2:Ubuntu");
          int sys= scanner.nextInt();
          AppareilInfo.SystemExploite systeme=null;
          switch(sys){
            
            case 0:
            systeme= AppareilInfo.SystemExploite.FreeDos;
            case 1:
            systeme= AppareilInfo.SystemExploite.Windows;
            case 2:
            systeme= AppareilInfo.SystemExploite.Ubuntu;

          }
          S.AjouterArticle(nom,prix,res,ram,disqueDur,process,carteGraphique,systeme,alimentation,quantArt);
        }
          case 1: {
          System.out.println("donner les caracteristiques de l'odinateur portable. nom, prix , resolution, processeur, ram,disque dur,carte graphique,capacite de batterie,quantite");
          String nom= scanner.next();
          Double prix= scanner.nextDouble();
          Double res= scanner.nextDouble();
          String process= scanner.next();
          Long ram= scanner.nextLong();
          Long disqueDur= scanner.nextLong();
          String carteGraphique= scanner.next();
          Long cap =scanner.nextLong();
          Long quantArt=scanner.nextLong();
          System.out.println("choisir un systeme d'exploitation: 0:FreeDos\n 1:Windows \n 2:Ubuntu");
          int sys= scanner.nextInt();
          AppareilInfo.SystemExploite systeme=null;
            switch(sys){
            
            case 0:
            systeme= AppareilInfo.SystemExploite.FreeDos;
            case 1:
            systeme= AppareilInfo.SystemExploite.Windows;
            case 2:
            systeme= AppareilInfo.SystemExploite.Ubuntu;
  
             }
          S.AjouterArticle(nom, prix, res, ram, disqueDur, process,carteGraphique, systeme ,cap,quantArt);
          } 
      case 2:{
       
        System.out.println("donner les caracteristiques de Mobile: nom, prix, resolution, processeur,  ram, System exploitation , appareil frontale, appareil arriere, nb Sim,  capacite batterie et quantite ");
        String nom= scanner.next();
        Double prix= scanner.nextDouble();
        Double reso= scanner.nextDouble();
        String process= scanner.next();
        Long ram= scanner.nextLong();
        double appareilFrontale=scanner.nextDouble();
        double appareilArriere=scanner.nextDouble();
        int nbSim=scanner.nextInt();
        long capaciteBatterie=scanner.nextLong();
        long quantArt=scanner.nextLong(); 
        System.out.println("choisir un systeme d'exploitation:  0: Android \n 1: IOS");
        int sys= scanner.nextInt();
        AppareilInfo.SystemExploite systeme=null;
        switch(sys){
            
    
          case 0:
           systeme= AppareilInfo.SystemExploite.Android;
          case 1:
           systeme= AppareilInfo.SystemExploite.IOS;
        }
      S.AjouterArticle( nom, prix, reso,process, ram, systeme, appareilFrontale, appareilArriere, nbSim, capaciteBatterie, quantArt );
        
        }
    case 3:{
      System.out.println("Donner les caracteristiques de composant du stockage : nomArt, prix, cap,  quantArt");
      String nomArt=scanner.next();
      Double px=scanner.nextDouble();
      int cap=scanner.nextInt();
      long quantArt=scanner.nextLong();
      S.AjouterArticle(nomArt, px, cap, quantArt);

    }
    case 4:{
      System.out.println("Donner les caracteristiques du peripherique : nomArt, px, tech, inter, quantite");
      String nomArt=scanner.next();
      Double px=scanner.nextDouble();
      String tech=scanner.next();
      String inter=scanner.next(); 
      long quantArt=scanner.nextLong();
      S.AjouterArticle(nomArt, px, tech, inter, quantArt);

        }

					/*String n=scanner.next();
					Double p=scanner.nextDouble();
          long q= scanner.nextLong();
					AjouterArticle(n,p,q); // on utlise la fonction d'ajout*/
					
      }
    }
  
         
			case 1: {
					String ref=scanner.next();
					long np=scanner.nextLong();
					S.incrementerQuantiteArticle(ref,np); // on utlise la fonction d'aumgmentation de class stock
					break;}
			case 2:{
          String reff=scanner.next();
          String nom=scanner.next();
          Double prix=scanner.nextDouble();
          long quant=scanner.nextLong();
          S.ModifierArticle( reff, nom, prix,quant);
          break;}
          
					/*String affichage=scanner.next();
				 	if (affichage=="croissant") {
						AffichageCroissant(ID,Reference,Nom,Prix); // fonction d'affichage croissant selon le prix
					}
					else if(affichage=="decroissant") {
						AffichageDecroissant(ID,Reference,Nom,Prix); // fonction d'affichage decroissant selon le prix
					}
					else {
						System.out.println("ERREUR");
				
					}

					break; */
        
				case 3: {
          
					String refs=scanner.next();
					S.SupprimerArticle(refs);// la fonction de suppression d'article de la class stock
					break;
        }
        case 4: {
         S.toString(); //importer la methode toString de la class stock pour consulter le stock
        }
         case 5: {
					System.out.println("QUITTER !");
         }
        }
  }
      
  
                 

  else if (perso == 1) {
    System.out.println("Bonjour cher/chère client(e)");
    int choixClient;
   
    do {
      System.out.println("0: Ajouter un article au panier");
      System.out.println("1: Consulter mon panier");
      System.out.println("2: Consulter les articles en stock");
      System.out.println("3: Mettre à jour quantité d'un article dans le panier");
      System.out.println("4: Supprimer un article du panier");
      System.out.println("5: Finaliser la commande");
      System.out.println("6: Annuler la commande");
      System.out.println("7: Quitter");
    choixClient = scanner.nextInt();
    switch (choixClient) {
    case 0:
    String choixSuivreAchat;
    do {
      System.out.println("Entrer la référence de l'article à ajouter au panier :");
    String choixReferenceArticlePanier =
    scanner.next();
    System.out.println("La quantité:");
    long choixQuantiteArticlePanier = scanner.nextLong();
    client.ajouterAuPanier(S,choixReferenceArticlePanier,choixQuantiteArticlePanier);
    System.out.println("Entrer oui pour suivre vos achats");
    choixSuivreAchat = scanner.next();
    } while (choixSuivreAchat.equals("oui"));
    break;
    case 1:
    client.afficherMonPanier();
    break;
    case 2:
    System.out.println("0: Par odre croissant \n1: Par ordre décroissant");
    int choixFiltre = scanner.nextInt();
    if (choixFiltre == 0)
client.afficherStockCroissant(S);
else
client.afficherStockDecroissant(S);
break;
case 3:
  System.out.println( "Entrer la référence de l'article que vous souhaitez modifier la quantité: ");
  String choixReferenceArticleModif = scanner.next();
  System.out.println("Entrer la nouvelle quantité:");
  long choixQuantiteArticleModif = scanner.nextLong();
  client.mettreAjourQuantite (choixReferenceArticleModif,choixQuantiteArticleModif);
  break;
case 4:
  System.out.println("Entrer la référence de l'article à supprimer:");
  String choixRefArticle = scanner.next();
  client.supprimerArticle(choixRefArticle);
  System.out.println("L'article de référence " + choixRefArticle +" est supprimé du panier avec succès");
  break;
case 5:
  client.finaliserCommande(S);
  break;
case 6:
  client.annulerCommande();
  break;
case 7:
  System.out.println("Au revoir!!");
  break;
default:
  System.out.println("Cette action n'est pas autorisée,réessayer!");
  break;
}
} while (choixClient != 7);
}
  else {
        System.out.println(" cette action pas autorisée");
  }
  



                 ArrayList<Integer> iD = new ArrayList <Integer> ();
                 iD.add(0);
                 iD.add(1);
                 iD.add(2);
                 iD.add(3);
                 iD.add(4);
                 ArrayList<String> reference = new ArrayList <String> ();                                                                                                                                                                                                                                    
                 reference.add("Prelton50");
                 reference.add("EeB21");
                 reference.add("SpNo2");
                 reference.add("MuSa3");
                 reference.add("SpA4");
                 ArrayList<String> nom = new ArrayList <String> ();
                 nom.add("Pc Portable Dell Vostro 3500");
                 nom.add("Ecouteur JBL T125BT");
                 nom.add("Smartphone INFINIX  Hot 10");
                 nom.add("Micro Casque 588 Filiare");
                 nom.add("Smartphone NOKIA C1");
                 ArrayList<Double> prix = new ArrayList<Double> ();
                 prix.add(1999.0);
                 prix.add(129.0);
                 prix.add(439.0);
                 prix.add(9.900);
                 prix.add(185.0);
                 
                
                }
          
              }
            
              
                
                
