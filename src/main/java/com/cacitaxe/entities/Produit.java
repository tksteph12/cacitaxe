package com.cacitaxe.entities;

import java.math.BigDecimal;
import java.util.Objects;



public class Produit {
	
	private String nom;
	//private boolean produitImporte;
	private BigDecimal prix;
	private OrigineProduit origineProduit;
	private TypeProduit typeProduit;
	//private int quantite;
		
	public Produit(String nom, BigDecimal prix, OrigineProduit origineProduit,
			TypeProduit typeProduit) {
		this.nom = Objects.requireNonNull(nom,"Le nom d'un produit ne peut être null");
		this.prix = Objects.requireNonNull(prix,"Le prix d'un produit ne peut être null");
		this.origineProduit = Objects.requireNonNull(origineProduit,"L'Origine du produit doit être renseignée");
		this.typeProduit = Objects.requireNonNull(typeProduit,"Type du produit doit être renseigné");
	}
	

	public Produit(OrigineProduit origineProduit, TypeProduit typeProduit) {
		this.origineProduit = origineProduit;
		this.typeProduit = typeProduit;
	}
	
	
	public BigDecimal calculPrixAvecTaxe(){
		
		return prix.add(calculTaxe());
		
	}
	
	public BigDecimal calculTaxe(){
		BigDecimal val = typeProduit.calculTaxe(prix).add(origineProduit.calculTaxe(prix));
		return val;
	}
	
	public String afficherProduit(){
		
		return this.toString();
	}
	
	@Override
	public String toString(){
		
		return "1 " + getNom() + " : " + calculPrixAvecTaxe();
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public BigDecimal getPrix() {
		return prix;
	}


	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}


	public OrigineProduit getOrigineProduit() {
		return origineProduit;
	}


	private void setOrigineProduit(OrigineProduit origineProduit) {
		this.origineProduit = origineProduit;
	}


	public TypeProduit getTypeProduit() {
		return typeProduit;
	}


	private void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}
	
}
