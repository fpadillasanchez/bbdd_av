package com.ub.edu.bda.Model;

import java.util.HashSet;
import java.util.Set;
    /**
     *
     * @author Oriol
     * @author Fernando
     */
public class Xef {

    private Integer int_Estrelles;
    private Integer id_Xef;
    private String nom;
    private Set <Recepta> receptes;
// afegim l'objecte cataleg en cardinalitat 1
    /**
     * Constructor 
     */
    public Xef() {
        super();
	// TODO Auto-generated constructor stub
    }
    /**
     * Constructor xef amb parametres
     * @param int_Estrelles integer
     * @param nom string
     */
    public Xef(Integer int_Estrelles, String nom) {
        this.int_Estrelles = int_Estrelles;
        this.nom = nom;
        this.receptes = new HashSet<Recepta>();
    }
    /**
     * Obtenim el numero estrelles
     * @return int_Estrelles
     */
    public Integer getInt_Estrelles() {
        return int_Estrelles;
    }
    /**
     * Afegim el numero d'estrelles del xef
     * @param int_Estrelles
     */
    public void setInt_Estrelles(Integer int_Estrelles) {
        this.int_Estrelles = int_Estrelles;
    }
    /**
     * Obtenim l'id del xef
     * @return id_Xef
     */
    public Integer getId_Xef() {
        return id_Xef;
    }
    /**
     * Afegim l'id del xef
     * @param id_Xef
     */
    public void setId_Xef(Integer id_Xef) {
        this.id_Xef = id_Xef;
    }
    /**
     * Obtenim el nom del xef
     * @return nom string
     */
    public String getNom() {
        return nom;
    }
    /**
     * Afegim el nom del xef string
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Xef{" + "int_Estrelles=" + int_Estrelles + ", id_Xef=" + id_Xef + ", nom=" + nom + '}';
    
    }
    /**
     * Afegim receptes relacionades amb el xef
     * @param recepta
     */
    public void setReceptes(Set recepta) {
        this.receptes = recepta;
    }
    /**
     * Obtenim receptes relacionades amb el xef
     * @return
     */
    public Set getReceptes() {
        return this.receptes;
    }

    /* Class functions */

    /**
     * afegeix rece
     * @param recepta
     */
    
    public void addRecepta(Recepta recepta) {
        this.receptes.add(recepta);
    }

}
