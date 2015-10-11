package com.ub.edu.bda.Model;


public class Plat {

    private Integer id_Plat;
    private String descripcio;
    private String nom;
    private Integer id_Recepta;
    private Recepta recepta;

    /**
     *
     * @author Oriol
     * @author Fernando
     */
    public Plat() {
        super();
	// TODO Auto-generated constructor stub
    }

    public Plat(String nom, String descrip, Recepta recepta) {
        this.descripcio = descrip;
        this.nom = nom;
        this.recepta = recepta;
                
    }

    public Integer getId_Plat() {
        return id_Plat;
    }

    public void setId_Plat(Integer id_Plat) {
        this.id_Plat = id_Plat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId_Recepta() {
        return id_Recepta;
    }

    public void setId_Recepta(Integer id_Recepta) {
        this.id_Recepta = id_Recepta;
    }

    public Recepta getRecepta() {
        return recepta;
    }

    public void setRecepta(Recepta recepta) {
        this.recepta = recepta;
    }

   

    @Override
    public String toString() {
        return "Plat{" + "id_Plat=" + id_Plat + ", descripcio=" + descripcio + ", nom=" + nom + ", id_Recepta=" + id_Recepta + '}';
    }

}
