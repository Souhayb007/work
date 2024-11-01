package com.mycompany.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        List<Produit> produits = new ArrayList<>();

    
        ProduitService produitService = new ProduitService(produits);

        Scanner scanner = new Scanner(System.in);
        
        int choix;
        
        do {
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Afficher la liste des produits");
            System.out.println("3. Mettre à jour un produit");
            System.out.println("4. supprimer un produit");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                   
                    System.out.print("ID du produit : ");
                    long id = scanner.nextLong();
                    System.out.print("Nom du produit : ");
                    String nom = scanner.next();
                    System.out.print("Prix du produit : ");
                    double prix = scanner.nextDouble();
                    System.out.print("Quantité du produit : ");
                    int quantite = scanner.nextInt();

                    
                    Produit nouveauProduit = new Produit(id, nom, prix, quantite);
                    produitService.createProduit(nouveauProduit);
                    break;

                case 2:
                    
                    System.out.println("Liste des produits :");
                    produitService.afficherProduits();
                    break;

                case 3:
                    
                    System.out.println("entrer le produit que tu veux modifier");
                    
                    long id1 = scanner.nextLong();
                    Produit p=produitService.readProduit(id1);
                    
                    if(p!=null)
                    {
                    	System.out.println("voici le produit "+p);
                    	 System.out.print("Nouveau nom du produit : ");
                    	 p.setNom(scanner.next());
                    	 System.out.print("Nouveau prix du produit : ");
                    	 p.setPrix(scanner.nextDouble());
                    	 System.out.print("Nouveau quantite du produit : ");
                    	 p.setQuantité(scanner.nextInt());
                    	 produitService.updateProduit(p);
                    	 System.out.println("produit est modifie par success");
                    } else {
                        System.out.println("Aucun produit trouvé avec l'ID spécifié.");
                    }
                    break;
                    
                case 4 :
                	 System.out.println("entrer le produit que tu veux supprimer");
                     
                     long id11 = scanner.nextLong();
                     Produit prod=produitService.readProduit(id11);
                     if(prod!=null)
                     {
                    	 System.out.println("voici le produit "+prod);
                    	  produitService.deleteProduit(id11);
                    	  System.out.println("produit est supprimer par success");
                     } else {
                         System.out.println("Aucun produit trouvé avec l'ID spécifié.");
                     }
                
                	

                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
                    break;
            }
        } while (choix != 5);

       
        scanner.close();
    }
}

        
        
       