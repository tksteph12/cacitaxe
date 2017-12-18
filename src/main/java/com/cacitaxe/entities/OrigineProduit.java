package com.cacitaxe.entities;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class OrigineProduit {

	private String nom;
	private Taxe taxe;
	
	private OrigineProduit(String nom, Taxe taxe) {
		this.nom = nom;
		this.taxe = taxe;
	}
	
	public BigDecimal calculTaxe(BigDecimal prix) {
		return  taxe.calculaterPrixAvecTaxe(prix);
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

	public static OrigineProduit IMPORTE = new OrigineProduit("importe", Taxe.TAXE_IMPORT);
	public static OrigineProduit LOCAL = new OrigineProduit("local", Taxe.NON_TAXE);
	

}
