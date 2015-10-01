package com.ub.edu.bda;

import java.util.Set;

public class Catalogo {
private Integer id ;
private String nombre ;
private String descripcion ;

//afegim l'objecte Articulo amb cardinalitat N
private Set<Recepta> articulos;

//afegim l'objecte Catalogo amb cardinalitat N

private Set<Xef> tiendas;

//afegim l'objecte Articulo amb cardinalitat N
private Set<Tipus_Menjar> tipusMenjar;

//afegim l'objecte Catalogo amb cardinalitat N

private Set<Plat> plat;



public Catalogo() {
	super();

}

public Catalogo(String nombre, String descripcion) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

//NOUS GETTERS I SETTERS

    public Set<Recepta> getArticulos() {
        return articulos;
    }

    public void setArticulos(Set<Recepta> articulos) {
        this.articulos = articulos;
    }

    public Set<Xef> getTiendas() {
        return tiendas;
    }

    public void setTiendas(Set<Xef> tiendas) {
        this.tiendas = tiendas;
    }

    public Set<Tipus_Menjar> getTipusMenjar() {
        return tipusMenjar;
    }

    public void setTipusMenjar(Set<Tipus_Menjar> tipusMenjar) {
        this.tipusMenjar = tipusMenjar;
    }

    public Set<Plat> getPlat() {
        return plat;
    }

    public void setPlat(Set<Plat> plat) {
        this.plat = plat;
    }



}

