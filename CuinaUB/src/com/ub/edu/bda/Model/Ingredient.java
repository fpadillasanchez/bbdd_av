package com.ub.edu.bda.Model;

public class Ingredient {
private Integer id_Ingredient;
private String refrigeracio; 
private String familia;
private String nom;
// afegim l'objecte cataleg en cardinalitat 1



public Ingredient() {
	super();
	// TODO Auto-generated constructor stub
}

    public Ingredient(String refrigeracio, String familia, String nom) {
        this.refrigeracio = refrigeracio;      
        this.familia = familia;
        this.nom = nom;
    }

    public Integer getId_Ingredient() {
        return id_Ingredient;
    }

    public void setId_Ingredient(Integer id_Ingredient) {
        this.id_Ingredient = id_Ingredient;
    }

    public String getRefrigeracio() {
        return refrigeracio;
    }

    public void setRefrigeracio(String refrigeracio) {
        this.refrigeracio = refrigeracio;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    

   

//NOUS GETTERS I SETTERS
}