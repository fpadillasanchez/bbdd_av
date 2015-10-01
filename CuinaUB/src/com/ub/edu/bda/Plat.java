package com.ub.edu.bda;

public class Plat {
private Integer id;
private String descripcion;
private double precio;

// afegim l'objecte cataleg en cardinalitat 1
private Catalogo catalogo;


public Plat() {
	super();
	// TODO Auto-generated constructor stub
}

    public Plat(Integer id, String descripcion, double precio, Catalogo catalogo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.catalogo = catalogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }




//NOUS GETTERS I SETTERS
public Catalogo getCatalogo() {
	return catalogo;
}

public void setCatalogo(Catalogo catalogo) {
	this.catalogo = catalogo;
}




}
