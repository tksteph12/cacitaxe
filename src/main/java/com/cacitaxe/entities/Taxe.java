package com.cacitaxe.entities;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class Taxe {

	private String nom ;
	private BigDecimal taux;
	private Taxe(String nom, BigDecimal montant){
		this.nom = nom;
		this.taux = montant;
	}
	
	public BigDecimal calculaterPrixAvecTaxe(BigDecimal prix) {
		return  TaxeUtil.arrondi(prix.multiply(taux));
	}
	
	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getTaux() {
		return taux;
	}

	private void setTaux(BigDecimal taux) {
		this.taux = taux;
	}
	

	public static Taxe NON_TAXE = new Taxe("Produit non taxe",new BigDecimal("0.00"));
	public static Taxe TVA = new Taxe("TVA",new BigDecimal("0.10"));
	public static Taxe TAXE_IMPORT = new Taxe("Produit importe",new BigDecimal("0.05"));
	

}
