package com.ub.edu.bda.Model;

import com.ub.edu.bda.Model.Plat;
import com.ub.edu.bda.Model.Ingredient;
import com.ub.edu.bda.Model.Familia_Ingredients;
import com.ub.edu.bda.Model.Recepta;
import com.ub.edu.bda.Model.Xef;
import com.ub.edu.bda.Model.Tipus_Menjar;
import java.util.Set;

public class Catalogo {

//afegim l'objecte Articulo amb cardinalitat N
private Set<Recepta> receptes;

//afegim l'objecte Catalogo amb cardinalitat N

private Set<Xef> tiendas;

//afegim l'objecte Articulo amb cardinalitat N
private Set<Tipus_Menjar> tipusMenjar;

//afegim l'objecte Catalogo amb cardinalitat N

private Set<Plat> plat;

private Set<Xef> xef;

private Set<Ingredient> ingredients;

private Set<Familia_Ingredients> familiaIngredients;

    
public Catalogo() {
	super();

}


//NOUS GETTERS I SETTERS

    public Set<Recepta> getReceptes() {
        return receptes;
    }

    public void setReceptes(Set<Recepta> receptes) {
        this.receptes = receptes;
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

    public Set<Xef> getXef() {
        return xef;
    }

    public void setXef(Set<Xef> xef) {
        this.xef = xef;
    }
    
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Familia_Ingredients> getFamiliaIngredients() {
        return familiaIngredients;
    }

    public void setFamiliaIngredients(Set<Familia_Ingredients> familiaIngredients) {
        this.familiaIngredients = familiaIngredients;
    }



}

