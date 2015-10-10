package com.ub.edu.bda.Model;

public class Tipus_Menjar {
private Integer id_Tipus;

private String nom;



public Tipus_Menjar() {
	super();
	// TODO Auto-generated constructor stub
}

    public Tipus_Menjar(String nom) {
        this.nom = nom;
    }



    public Integer getId_Tipus() {
        return id_Tipus;
    }

    public void setId_Tipus(Integer id_Tipus) {
        this.id_Tipus = id_Tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
