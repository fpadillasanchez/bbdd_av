package com.ub.edu.bda.Model;

public class Recepta {
private Integer id_Recepta;
private String elaboracio;
private String temps;
private String nom;
private String dificultat;
private Integer id_Xef;




public Recepta() {
	super();
	// TODO Auto-generated constructor stub
}

    public Recepta(Integer id_Recepta, String elaboracio, String temps, String nom, String dificultat, Integer id_Xef, Integer id_Plat) {
        this.id_Recepta = id_Recepta;
        this.elaboracio = elaboracio;
        this.temps = temps;
        this.nom = nom;
        this.dificultat = dificultat;
        this.id_Xef = id_Xef;
       }

    public Integer getId_Recepta() {
        return id_Recepta;
    }

    public void setId_Recepta(Integer id_Recepta) {
        this.id_Recepta = id_Recepta;
    }

    public String getElaboracio() {
        return elaboracio;
    }

    public void setElaboracio(String elaboracio) {
        this.elaboracio = elaboracio;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDificultat() {
        return dificultat;
    }

    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }

    public Integer getId_Xef() {
        return id_Xef;
    }

    public void setId_Xef(Integer id_Xef) {
        this.id_Xef = id_Xef;
    }

    
    public String toStringNomReceptId() {
        return "Recepta{" + "id_Recepta=" + id_Recepta + ", nom=" + nom + '}';
    }













}
