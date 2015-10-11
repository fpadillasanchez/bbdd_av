package com.ub.edu.bda.Model;

import java.util.HashSet;
import java.util.Set;

public class Recepta {

    private Integer id_Recepta;
    private String elaboracio;
    private String temps;
    private String nom;
    private String dificultat;
    private Xef xef;
    private Set<Plat> plats;
    private Tipus_Menjar tMenjar;
    
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    /**
     *
     * @author Oriol
     * @author Fernando
     */
    public Recepta() {
        super();
	// TODO Auto-generated constructor stub
    }

    public Recepta(String elaboracio, String temps, String nom, String dificultat, Xef xef, Tipus_Menjar tipMenjar) {

        this.elaboracio = elaboracio;
        this.temps = temps;
        this.nom = nom;
        this.dificultat = dificultat;
        this.xef = xef;
        this.tMenjar = tMenjar;

    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getId_Recepta() {
        return id_Recepta;
    }

    public Xef getXef() {
        return xef;
    }

    public void setXef(Xef xef) {
        this.xef = xef;
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

    public Set<Plat> getPlats() {
        return plats;
    }

    public void setPlats(Set<Plat> plats) {
        this.plats = plats;
    }

    public Tipus_Menjar gettMenjar() {
        return tMenjar;
    }

    public void settMenjar(Tipus_Menjar tMenjar) {
        this.tMenjar = tMenjar;
    }

    public void setIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    
   
    
    

}
