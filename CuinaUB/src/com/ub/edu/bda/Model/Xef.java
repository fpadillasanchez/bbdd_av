package com.ub.edu.bda.Model;

import java.util.Set;

public class Xef  {
private Integer estrelles;
private Integer id_Xef;
private String nom;
//private Set<Recepta> receptes;
// afegim l'objecte cataleg en cardinalitat 1



public Xef() {
	
	// TODO Auto-generated constructor stub
}

    public Xef(Integer estrelles, String nom) {
        this.estrelles = estrelles;
        this.nom = nom;

    }

    public Integer getInt_Estrelles() {
        return estrelles;
    }

    public void setInt_Estrelles(Integer int_Estrelles) {
        this.estrelles = int_Estrelles;
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
   
    
    

   


}