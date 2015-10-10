package com.ub.edu.bda.Model;

public class Ingredient {
private Integer id_Ingredient;
private String refrigeracio; 
private Integer id_Familia;
private String familia;
private String nom;
// afegim l'objecte cataleg en cardinalitat 1



public Ingredient() {
	super();
	// TODO Auto-generated constructor stub
}

    public Ingredient(Integer id_Ingredient, String refrigeracio, Integer id_Familia, String familia, String nom) {
        this.id_Ingredient = id_Ingredient;
        this.refrigeracio = refrigeracio;
        this.id_Familia = id_Familia;
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

    public Integer getId_Familia() {
        return id_Familia;
    }

    public void setId_Familia(Integer id_Familia) {
        this.id_Familia = id_Familia;
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