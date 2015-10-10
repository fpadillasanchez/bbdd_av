package com.ub.edu.bda.Model;

public class Familia_Ingredients {

    private Integer id_familiaIngredients;
    private String descripcio;
    private String nom;

// afegim l'objecte cataleg en cardinalitat 1


    public Familia_Ingredients() {
        super();
	// TODO Auto-generated constructor stub
    }


    public Familia_Ingredients(String descripcio, String nom) {
        super();
        this.descripcio = descripcio;
        this.nom = nom;
    }

    public Integer getId_familiaIngredients() {
        return id_familiaIngredients;
    }

    public void setId_familiaIngredients(Integer id_familiaIngredients) {
        this.id_familiaIngredients = id_familiaIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }
//NOUS GETTERS I SETTERS


    public String toStringIDNom() {
        return "Familia_Ingredients{" + "id_Familia=" + id_familiaIngredients + ", nom=" + nom + '}';
    }

}
