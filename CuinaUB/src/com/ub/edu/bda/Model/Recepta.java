package com.ub.edu.bda.Model;

public class Recepta {
private Integer id_Recepta;
private String elaboracio;
private String temps;
private String nom;
private String dificultat;



public Recepta() {
	super();
	// TODO Auto-generated constructor stub
}

    public Recepta(String elaboracio, String temps, String nom, String dificultat) {
        
        this.elaboracio = elaboracio;
        this.temps = temps;
        this.nom = nom;
        this.dificultat = dificultat;

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














}
