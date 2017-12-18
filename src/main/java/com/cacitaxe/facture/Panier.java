package com.cacitaxe.facture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.log4j.Logger;

import com.cacitaxe.entities.CaciLogger;
import com.cacitaxe.entities.Produit;

import static java.util.stream.Collectors.joining;


public class Panier {
	
	private List<Produit> listeArticles  = new ArrayList<Produit>();
	
	public Panier() {
		CaciLogger.logInfo("Nouveau panier crée");

	}

	public BigDecimal calculTaxesPanier(){
		BigDecimal val = new BigDecimal("0.0");
		for (Produit article : listeArticles){			
			val = val.add(article.calculTaxe());
		}
		return val;
	}
	
	public BigDecimal calculMontantPanierAvecTaxes(){
		BigDecimal panier = new BigDecimal("0");
		for (Produit article : listeArticles){
			panier = panier.add(article.calculPrixAvecTaxe());
		}
		return panier;
		
	}
	
	public BigDecimal calculMontantPanierSansTaxe(){
		BigDecimal panier = new BigDecimal("0");
		for (Produit article : listeArticles){
			panier.add(article.getPrix());
		}
		return panier;
	}
		
	public boolean ajouterProduit(Produit article){
		listeArticles.add(article);
		
		CaciLogger.logInfo("Nouveau produit "+ article.getNom() +" ajouté au panier ");
		return true;
	}
	
	public String imprimerFactureDetaillee(Panier panier){
		CaciLogger.logInfo("Impression de la facture");
		
		/*StringBuilder facture = new StringBuilder("\n");
		for (Produit article : listeArticles){
			facture.append(article.afficherProduit() + "\n");
		}
		facture.append("Montant des taxes : " + calculTaxesPanier()+ "\n");
		facture.append("Total : " + calculMontantPanierAvecTaxes()+ "\n");
		CaciLogger.logInfo(facture.toString());
		return facture.toString();	*/
		//logger.info("Impression de la facture");
			
		StringJoiner facture = new StringJoiner("\n")
		   .add(listeArticles.stream().map(Produit::toString).collect(joining("\n")))
		   .add("Montant des taxes : " + calculTaxesPanier())
		   .add("Total : " + calculMontantPanierAvecTaxes());
		
		CaciLogger.logInfo(facture.toString());
		
		return facture.toString();	

	} 
	
}
