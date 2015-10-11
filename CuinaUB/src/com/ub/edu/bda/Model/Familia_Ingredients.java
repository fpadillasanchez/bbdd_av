/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.edu.bda.Model;

/**
 *
 * @author Fernando
 */
public class Familia_Ingredients {
    private Integer id_FamiliaIngredients;
    private String nom;
    private String descripcio;

    public Familia_Ingredients(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public Integer getId_FamiliaIngredients() {
        return id_FamiliaIngredients;
    }

    public void setId_FamiliaIngredients(Integer id_FamiliaIngredients) {
        this.id_FamiliaIngredients = id_FamiliaIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    
}
