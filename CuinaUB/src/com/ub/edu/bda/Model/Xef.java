package com.ub.edu.bda.Model;

import java.util.Set;

public class Xef {

    private Integer int_Estrelles;
    private Integer id_Xef;
    private String nom;
    private Set<Recepta> receptes;
// afegim l'objecte cataleg en cardinalitat 1

    /**
     *
     * @author Oriol
     * @author Fernando
     */

    public Xef() {
        super();
	// TODO Auto-generated constructor stub
    }

    public Xef(Integer int_Estrelles, String nom) {
        this.int_Estrelles = int_Estrelles;
        this.nom = nom;

    }

    public Integer getInt_Estrelles() {
        return int_Estrelles;
    }

    public void setInt_Estrelles(Integer int_Estrelles) {
        this.int_Estrelles = int_Estrelles;
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

    public void setReceptes(Set<Recepta> recepta) {
        this.receptes = recepta;
    }

    public Set<Recepta> getReceptes() {
        return this.receptes;
    }

    /* Class functions */
    public void addRecepta(Recepta recepta) {
        this.receptes.add(recepta);
    }

}
