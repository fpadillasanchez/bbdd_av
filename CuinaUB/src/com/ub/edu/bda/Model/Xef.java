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
public class Xef {
    
    private Integer id_Xef;
    private Integer int_Estrelles;
    private String nom;

    public Xef(Integer int_Estrelles, String nom) {
        this.int_Estrelles = int_Estrelles;
        this.nom = nom;
    }

    public Integer getId_Xef() {
        return id_Xef;
    }

    public void setId_Xef(Integer id_Xef) {
        this.id_Xef = id_Xef;
    }

    public Integer getInt_Estrelles() {
        return int_Estrelles;
    }

    public void setInt_Estrelles(Integer int_Estrelles) {
        this.int_Estrelles = int_Estrelles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
