package com.ub.edu.bda;

public class familia_Ingredients {
private Integer id_Familia;
private String descripcio;
private String nom;

// afegim l'objecte cataleg en cardinalitat 1
private Catalogo catalogo;


public familia_Ingredients() {
	super();
	// TODO Auto-generated constructor stub
}

public familia_Ingredients(Integer id, String descripcio,
		String nom) {
	super();
	this.id_Familia = id_Familia;
	this.descripcio = descripcio;
	this.nom = nom;
}



public familia_Ingredients(String descripcio, String nom) {
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
public Catalogo getCatalogo() {
	return catalogo;
}

public void setCatalogo(Catalogo catalogo) {
	this.catalogo = catalogo;
}




}
