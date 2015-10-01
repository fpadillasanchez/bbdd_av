package com.ub.edu.bda;

public class Tipus_Menjar {
private Integer id_Tipus;
private String nom;
// afegim l'objecte cataleg en cardinalitat 1
private Catalogo catalogo;


public Tipus_Menjar() {
	super();
	// TODO Auto-generated constructor stub
}

    public Tipus_Menjar(Integer id_Tipus, String nom, Catalogo catalogo) {
        this.id_Tipus = id_Tipus;
        this.nom = nom;
        this.catalogo = catalogo;
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
public Catalogo getCatalogo() {
	return catalogo;
}

public void setCatalogo(Catalogo catalogo) {
	this.catalogo = catalogo;
}




}
