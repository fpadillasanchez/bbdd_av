package com.ub.edu.bda;

public class pertany_Recepta_Ingredient {
private Integer id_R_I;
private Integer id_Recepta;
private Integer id_Ingredient;

// afegim l'objecte cataleg en cardinalitat 1
private Catalogo catalogo;


public pertany_Recepta_Ingredient() {
	super();
	// TODO Auto-generated constructor stub
}

public pertany_Recepta_Ingredient(Integer id_R_I, Integer id_Recepta, Integer id_Ingredient) {
	super();
	this.id_R_I = id_R_I;
	this.id_Recepta = id_Recepta;
	this.id_Ingredient = id_Ingredient;
}



public pertany_Recepta_Ingredient(Integer id_Recepta, Integer id_Ingredient) {
	super();
	this.id_Recepta = id_Recepta;
	this.id_Ingredient = id_Ingredient;
}

public Integer getid_R_I() {
	return id_R_I;
}

public void setId_R_I(Integer id_R_I) {
	this.id_R_I = id_R_I;
}

public Integer getid_Recepta() {
	return id_Recepta;
}

public void setId_Ingredient(Integer id_Ingredient) {
	this.id_Ingredient = id_Ingredient;
}

//NOUS GETTERS I SETTERS
public Catalogo getCatalogo() {
	return catalogo;
}

public void setCatalogo(Catalogo catalogo) {
	this.catalogo = catalogo;
}




}
