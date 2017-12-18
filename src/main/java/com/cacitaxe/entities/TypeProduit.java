package com.cacitaxe.entities;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class TypeProduit {

	public String nom;
	public Taxe taxe;

	private TypeProduit(String nom, Taxe taxe){
        	 this.nom = nom;
        	 this.taxe = taxe;
        	 CaciLogger.logInfo("Nouveau type de produit " + nom + " enregistré");
    }
	
	public BigDecimal calculTaxe(BigDecimal prix) {

		return taxe.calculaterPrixAvecTaxe(prix);
    }
	
	
	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	public Taxe getTaxe() {
		return taxe;
	}

	private void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}



	public static TypeProduit LIVRE = new TypeProduit("livre", Taxe.NON_TAXE);
	public static TypeProduit NOURRITURE = new TypeProduit("nourriture", Taxe.NON_TAXE);
	public static TypeProduit MEDICAMENT = new TypeProduit("medicament", Taxe.NON_TAXE);
	public static TypeProduit GENERIQUE = new TypeProduit("generique", Taxe.TVA);

	
}
