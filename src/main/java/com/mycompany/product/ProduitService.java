package com.mycompany.product;

import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService(List<Produit> produits) {
        this.produits = produits;
    }
    public void afficherProduits() {
        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }


    public void createProduit(Produit produit) {
        if (produitExist(produit.getId()) || produitExist(produit.getNom())) {
            throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
        }

        if (produit.getPrix() < 0 || produit.getQuantité() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }

        produits.add(produit);
    }

    public Produit readProduit(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        return null;
    }

    public void updateProduit(Produit produit) {
        if (!produitExist(produit.getId())) {
            throw new IllegalArgumentException("Le produit avec cet ID n'existe pas.");
        }

        if (produit.getPrix() < 0 || produit.getQuantité() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }

        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId().equals(produit.getId())) {
                produits.set(i, produit);
                break;
            }
        }
    }

    public void deleteProduit(Long id) {
        if (!produitExist(id)) {
            throw new IllegalArgumentException("Le produit avec cet ID n'existe pas.");
        }

     
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId().equals(id)) {
                produits.remove(i);
                break;
            }
        }
    }

    private boolean produitExist(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean produitExist(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }
}
