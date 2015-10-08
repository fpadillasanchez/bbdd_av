package com.ub.edu.bda.Model;

public class Xef {
private Integer int_Estrelles;
private Integer id_Xef;
private String nom;
// afegim l'objecte cataleg en cardinalitat 1
private Catalogo catalogo;


public Xef() {
	super();
	// TODO Auto-generated constructor stub
}

    public Xef(Integer int_Estrelles, Integer id_Xef, String nom) {
        this.int_Estrelles = int_Estrelles;
        this.id_Xef = id_Xef;
        this.nom = nom;
        this.catalogo = catalogo;
    }

    public Integer getInt_Estrelles() {
        return int_Estrelles;
    }

    public void setInt_Estrelles(Integer int_Estrelles) {
        this.int_Estrelles = int_Estrelles;
    }

    public Integer getId_Xef() {
        return id_Xef;
    }

    public void setId_Xef(Integer id_Xef) {
        this.id_Xef = id_Xef;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toStringNomId() {
        return "Xef{" + "id_Xef=" + id_Xef + ", nom=" + nom + '}';
    }
    
    

   

//NOUS GETTERS I SETTERS
public Catalogo getCatalogo() {
	return catalogo;
}

public void setCatalogo(Catalogo catalogo) {
	this.catalogo = catalogo;
}
}