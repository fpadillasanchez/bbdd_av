package com.ub.edu.bda.Model;

public class Tipus_Menjar {
private Integer id_Tipus;
private Integer id_Recepta;
private String nom;

private Catalogo catalogo;

public Tipus_Menjar() {
	super();
	// TODO Auto-generated constructor stub
}

    public Tipus_Menjar(Integer id_Tipus, Integer id_Recepta, String nom) {
        this.id_Tipus = id_Tipus;
        this.nom = nom;
        this.id_Recepta = id_Recepta;
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


//NOUS GETTERS I SETTERS
    public Integer getId_Recepta() {
        return id_Recepta;
    }

    public void setId_Recepta(Integer id_Recepta) {
        this.id_Recepta = id_Recepta;
    }




}
