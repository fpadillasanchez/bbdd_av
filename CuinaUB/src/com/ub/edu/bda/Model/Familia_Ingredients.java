package com.ub.edu.bda.Model;

import java.util.Set;

/**
 *
 * @author Oriol
 * @author Fernando
 */
public class Familia_Ingredients {

    private Integer id_familiaIngredients;
    private String descripcio;
    private String nom;
    
    private Set <Ingredient> ingredient;
 /**
  *constructor Familia_ingredients afegim l'objecte cataleg en cardinalitat 1
  */ 
    public Familia_Ingredients() {
        super();
        // TODO Auto-generated constructor stub
    }
 /**
  *Modificacio constructor
  *
  * @param descripcio parametre descripcio de Familia ingredients
  * @param nom parametre nom de Familia ingredients
  */
    public Familia_Ingredients(String descripcio, String nom) {
        super();
        this.descripcio = descripcio;
        this.nom = nom;
    }
 /**
  *Retorna id de familia integer
  * @return integer id_familiaIngredients 
  */
    public Integer getId_familiaIngredients() {
        return id_familiaIngredients;
    }
/**
  *Afegeix id
  *
  * @param id_familiaIngredients integer
  */
    public void setId_familiaIngredients(Integer id_familiaIngredients) {
        this.id_familiaIngredients = id_familiaIngredients;
    }
/**
  *Retorna nom de familia string
  * @return string amb el nom
  */
    public String getNom() {
        return nom;
    }
/**
  *Afegeix nom
  *
  * @param nom string
  */
    public void setNom(String nom) {
        this.nom = nom;
    }
/**
  *Retorna descripcio de familia string
  * @return string amb la dexcripxio
  */
    public String getDescripcio() {
        return descripcio;
    }
/**
  *Afegeix descripcio
  *
  * @param descripcio string
  */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     *
     * @return nom
     */
    public String getnom() {
        return nom;
    }

    /**
     *
     * @param nom string
     */
    public void setnom(String nom) {
        this.nom = nom;
    }
    public Set getIngredient()
    {
        return ingredient;
    }

    public void setIngredient(Set ingredient)
    {
        this.ingredient = ingredient;
    }
//NOUS GETTERS I SETTERS
/**
  *Retorna  string
  * @return string amb tect i id i nom
  */
    public String toStringIDNom() {
        return " Familia_Ingredients " 
                + " ID de la familia " + id_familiaIngredients 
                + " Nom de la familia de ingredients " + nom;
    }
    public void addIngredient(Ingredient ingredient) {
        this.ingredient.add(ingredient);
    }
}
