package com.ub.edu.bda.Model;

import java.util.Set;

public class Plat {

    private Integer id_Plat;
    private String descripcio;
    private String nom;
    private Integer id_Recepta;
    private Set<Recepta> receptes;

    /**
     *
     * @author Oriol
     * @author Fernando
     */
    public Plat() {
        super();
	// TODO Auto-generated constructor stub
    }

    public Plat(String nom, String descrip) {
        this.descripcio = descrip;
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Plat{" + "id_Plat=" + id_Plat + ", descripcio=" + descripcio + ", nom=" + nom + ", id_Recepta=" + id_Recepta + '}';
    }

}
