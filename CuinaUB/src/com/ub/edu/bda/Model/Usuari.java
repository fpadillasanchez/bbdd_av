package com.ub.edu.bda.Model;

    /**
     *
     * @author Oriol
     * @author Fernando
     */
public class Usuari {
    private int id;
    private String nom;
    private String pass;
    
    /**
     *Constructor usuari
     */
    public Usuari() {
        super();
    }

    /**
     * 
     * @param nom
     * @param pass
     */
    public Usuari( String nom, String pass ){
        this.nom = nom;
        this.pass = pass;
    }

    /**
     * Assignar id usuari
     * @param id integer
     */
    public void setId(int id) {
       this.id = id;
    }

    /**
     * Consulta id usuari
     * @return id int
     */
    public int getId() {
       return this.id;
    }

    /**
     * Afegeix nom usuari
     * @param nom string
     */
    public void setNom(String nom) {
       this.nom = nom;
    }

    /**
     * Consulta nom usuari
     * @return nom string
     */
    public String getNom() {
       return this.nom;
    }

    /**
     * Afegeix password usuari
     * @param pass string
     */
    public void setPass(String pass) {
       this.pass = pass;
    }

    /**
     * Llegeix password usuari
     * @return passs string
     */
    public String getPass() {
       return this.pass;
    }
}
    