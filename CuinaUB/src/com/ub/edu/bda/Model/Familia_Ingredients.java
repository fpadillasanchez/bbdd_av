package com.ub.edu.bda.Model;

public class Familia_Ingredients {

    private Integer id_Familia;
    private String descripcio;
    private String nom;

// afegim l'objecte cataleg en cardinalitat 1


    public Familia_Ingredients() {
        super();
	// TODO Auto-generated constructor stub
    }

    public Familia_Ingredients(Integer id, String descripcio,
            String nom) {
        super();
        this.id_Familia = id_Familia;
        this.descripcio = descripcio;
        this.nom = nom;
    }

    public Familia_Ingredients(String descripcio, String nom) {
        super();
        this.descripcio = descripcio;
        this.nom = nom;
    }

    public Integer getId_Familia() {
        return id_Familia;
    }

    public void setId(Integer id_Familia) {
        this.id_Familia = id_Familia;
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
        return "Familia_Ingredients{" + "id_Familia=" + id_Familia + ", nom=" + nom + '}';
    }

}
