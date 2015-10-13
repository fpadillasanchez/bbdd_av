package com.ub.edu.bda.Model;

    /**
     *
     * @author Oriol
     * @author Fernando
     */
public class Plat {

    private Integer id_Plat;
    private String descripcio;
    private String nom;
    private Integer id_Recepta;
    private Recepta recepta;


    /**
     * constructor buit
     */
    public Plat() {
        super();
	// TODO Auto-generated constructor stub
    }
    /**
     * Modificacio constructor
     * @param nom del plat
     * @param descrip decripcio
     * @param recepta la recepta que correspon al plat
     */
    public Plat(String nom, String descrip, Recepta recepta) {
        this.descripcio = descrip;
        this.nom = nom;
        this.recepta = recepta;
                
    }
    /**
     * Retorna id del plat
     * @return id_plat obtingut
     */
    public Integer getId_Plat() {
        return id_Plat;
    }
    /**
     * Afegim id de plat
     * @param id_Plat que volem introduir
     */
    public void setId_Plat(Integer id_Plat) {
        this.id_Plat = id_Plat;
    }
   /**
     * Retorna stringg amb descripcio del plat
     * @return descripcio del plat
     */
    public String getDescripcio() {
        return descripcio;
    }
    /**
     * Afegeix descripcioal plat
     * @param descripcio del plat
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    /**
     * Obte el nom del plat
     * @return nom del plat
     */
    public String getNom() {
        return nom;
    }
    /**
     * Afegeix nom
     * @param nom string a afegir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Obte id de la recepta
     * @return id de la recepta
     */
    public Integer getId_Recepta() {
        return id_Recepta;
    }
    /**
     * Guarda id recepta
     * @param id_Recepta integer a guardar
     */
    public void setId_Recepta(Integer id_Recepta) {
        this.id_Recepta = id_Recepta;
    }
    /**
     * Obte la recepta relacionada amb plat
     * @return recepta
     */
    public Recepta getRecepta() {
        return recepta;
    }
    /**
     *
     * @param recepta que volem guardar relacionada amb plat
     */
    public void setRecepta(Recepta recepta) {
        this.recepta = recepta;
    }

   

    @Override
    public String toString() {
        return "Plat{" 
                + " ID del plat: " + id_Plat 
                + " Descripció del plat: " + descripcio 
                + " Nom de plat: " + nom 
                + " ID  de la recepta a la que pertany: " + id_Recepta;
    }

}
