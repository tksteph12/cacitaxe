package com.cacitaxe;


import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cacitaxe.entities.OrigineProduit;
import com.cacitaxe.entities.Produit;
import com.cacitaxe.entities.TypeProduit;
import com.cacitaxe.facture.Panier;


public class TestFacturePanier {
    String imprimeFacture = "";
    String attendu = "";
    Produit produit;
    Panier panier;
    TypeProduit typeProduit;
    OrigineProduit origineProduit;

	@Before
	public void initialiser(){
		
	}
	
	@Test
	public void testOutput1() {
		panier = new Panier();
		
		produit = new Produit("livre", new BigDecimal("12.49"), OrigineProduit.LOCAL, TypeProduit.LIVRE);
		panier.ajouterProduit(produit);
		
		produit = new Produit("CD musical", new BigDecimal("14.99"), OrigineProduit.LOCAL, TypeProduit.GENERIQUE);
		panier.ajouterProduit(produit);
		
		produit = new Produit("barre de chocolat", new BigDecimal("0.85"), OrigineProduit.LOCAL, TypeProduit.NOURRITURE);
		panier.ajouterProduit(produit);

		imprimeFacture = panier.imprimerFactureDetaillee(panier);
		
		attendu = "1 livre : 12.49" + "\n" +
	              "1 CD musical : 16.49" + "\n" +
	              "1 barre de chocolat : 0.85" + "\n" +
	              "Montant des taxes : 1.50" + "\n" +
	              "Total : 29.83";
        Assert.assertEquals(attendu, imprimeFacture);
	}
	
	@Test
	public void testOutput2() {
		panier = new Panier();
		produit = new Produit("boîte de chocolats importée", new BigDecimal("10.00"), OrigineProduit.IMPORTE, TypeProduit.NOURRITURE);
		panier.ajouterProduit(produit);
		
		produit = new Produit("flacon de parfum importé", new BigDecimal("47.50"), OrigineProduit.IMPORTE, TypeProduit.GENERIQUE);
		panier.ajouterProduit(produit);

		imprimeFacture = panier.imprimerFactureDetaillee(panier);

		attendu = "1 boîte de chocolats importée : 10.50" + "\n" +
	              "1 flacon de parfum importé : 54.65" + "\n" +
	              "Montant des taxes : 7.65" + "\n" +
	              "Total : 65.15";
        Assert.assertEquals(attendu, imprimeFacture);
	}
	
	@Test
	public void testOutput3() {
		panier = new Panier();
		
		produit = new Produit("flacon de parfum importé", new BigDecimal("27.99"), OrigineProduit.IMPORTE, TypeProduit.GENERIQUE);
		panier.ajouterProduit(produit);
		
		produit = new Produit("flacon de parfum", new BigDecimal("18.99"), OrigineProduit.LOCAL, TypeProduit.GENERIQUE);
		panier.ajouterProduit(produit);
		
		produit = new Produit("boîte de pilules contre la migraine", new BigDecimal("9.75"), OrigineProduit.LOCAL, TypeProduit.MEDICAMENT);
		panier.ajouterProduit(produit);
		
		produit = new Produit("boîte de chocolats importés", new BigDecimal("11.25"), OrigineProduit.IMPORTE, TypeProduit.NOURRITURE);
		panier.ajouterProduit(produit);

		imprimeFacture = panier.imprimerFactureDetaillee(panier);

		attendu = "1 flacon de parfum importé : 32.19" + "\n" +
	              "1 flacon de parfum : 20.89" + "\n" +
	              "1 boîte de pilules contre la migraine : 9.75" + "\n" +
	              "1 boîte de chocolats importés : 11.85" + "\n" +
	              "Montant des taxes : 6.70" + "\n" +
	              "Total : 74.68";
        Assert.assertEquals(attendu, imprimeFacture);
	}
	
}
