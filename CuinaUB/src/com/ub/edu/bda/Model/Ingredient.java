package com.ub.edu.bda.Model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Oriol
 * @author Fernando
 */
public class Ingredient {

    private Integer id_Ingredient;
    private String refrigeracio;
    private String familia;
    private String nom;
    private Set<Recepta> receptes;
// afegim l'objecte cataleg en cardinalitat 1
 /**
  *constructor Familia_ingredients
  */
    public Ingredient() {
        super();
	// TODO Auto-generated constructor stub
    }
/**
  *Modificacio 
  *
  * @param refrigeracio parametre refrigeracio
  * @param nom parametre nom
  * @param familia parametre nom
  */
    public Ingredient(String refrigeracio, String familia, String nom) {
        this.refrigeracio = refrigeracio;
        this.familia = familia;
        this.nom = nom;
        this.receptes = new HashSet<Recepta>();
    }
 /**
  *Retorna id de ingredient integer
  * @return integer id
  */
    public Integer getId_Ingredient() {
        return id_Ingredient;
    }
/**
  *Afegeix id
  *
  * @param id_Ingredient integer
  */
    public void setId_Ingredient(Integer id_Ingredient) {
        this.id_Ingredient = id_Ingredient;
    }
/**
  *Retorna set de receptes
  * @return receptes
  */
    public Set<Recepta> getReceptes() {
        return receptes;
    }
  /**
  *Afegeix set de receptes
  *
  * @param receptes Set
  */
    public void setReceptes(Set<Recepta> receptes) {
        this.receptes = receptes;
    }
 /**
  *Retorna regrigeracio
  * @return refrigeracio
  */
    public String getRefrigeracio() {
        return refrigeracio;
    }
  /**
  *Afegeix tipus de refrigeracio
  *
  * @param refrigeracio string
  */
    public void setRefrigeracio(String refrigeracio) {
        this.refrigeracio = refrigeracio;
    }
 /**
  *Retorna familia a que pertany
  * @return familia
  */
    public String getFamilia() {
        return familia;
    }
  /**
  *Afegeix tipus de familia
  *
  * @param familia string
  */
    public void setFamilia(String familia) {
        this.familia = familia;
    }
 /**
  *Retorna noom
  * @return nom
  */
    public String getNom() {
        return nom;
    }
  /**
  *Afegeixnom
  *
  * @param nom string
  */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return " Ingredient " 
                + " ID del ingredient: " + id_Ingredient 
                + " Necessita refrigeracio: " + refrigeracio 
                + " Familia del ingredient: " + familia 
                + " Nom del ingredient: " + nom;
    }
    
    

//NOUS GETTERS I SETTERS

    /**
     * Relacionem ingredient amb recepta
     * @param recepta
     */
        public void setIngredients(Recepta recepta) {
        this.receptes.add(recepta);
    }
    
    /**
     *
     * @param recepta
     */
    public void addRecepta(Recepta recepta) {
        this.receptes.add(recepta);
    }
}
