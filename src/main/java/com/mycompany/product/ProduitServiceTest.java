package com.mycompany.product;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProduitServiceTest {

    private ProduitService produitService;
    private List<Produit> produits;

    @Before
    public void setUp() {
        produits = new ArrayList<>();
        produitService = new ProduitService(produits);
    }

    @Test
    public void testCreateProduit() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);
        assertTrue(produits.contains(produit));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateProduitExistingId() {
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        Produit produit2 = new Produit(1L, "Produit2", 15.0, 3);
        produitService.createProduit(produit1);
        produitService.createProduit(produit2); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateProduitExistingNom() {
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        Produit produit2 = new Produit(2L, "Produit1", 15.0, 3);
        produitService.createProduit(produit1);
        produitService.createProduit(produit2); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateProduitInvalidPrix() {
        Produit produit = new Produit(1L, "Produit1", -10.0, 5);
        produitService.createProduit(produit); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateProduitInvalidQuantite() {
        Produit produit = new Produit(1L, "Produit1", 10.0, -5);
        produitService.createProduit(produit); 
    }

    @Test
    public void testReadProduit() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);
        assertEquals(produit, produitService.readProduit(1L));
    }

    @Test
    public void testReadProduitNotFound() {
        assertNull(produitService.readProduit(1L)); 
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);

        Produit nouveauProduit = new Produit(1L, "ProduitModifie", 15.0, 3);
        produitService.updateProduit(nouveauProduit);

        assertTrue(produits.contains(nouveauProduit));
        assertFalse(produits.contains(produit));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateProduitNotFound() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.updateProduit(produit); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateProduitInvalidPrix() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);

        Produit nouveauProduit = new Produit(1L, "ProduitModifie", -15.0, 3);
        produitService.updateProduit(nouveauProduit); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateProduitInvalidQuantite() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);

        Produit nouveauProduit = new Produit(1L, "ProduitModifie", 15.0, -3);
        produitService.updateProduit(nouveauProduit); 
    }

    @Test
    public void testDeleteProduit() {
        Produit produit = new Produit(1L, "Produit1", 10.0, 5);
        produitService.createProduit(produit);
        produitService.deleteProduit(1L);
        assertFalse(produits.contains(produit));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteProduitNotFound() {
        produitService.deleteProduit(1L);
    }

    
}
