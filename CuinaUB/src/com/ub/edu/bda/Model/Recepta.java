package com.ub.edu.bda.Model;

import java.util.HashSet;
import java.util.Set;
    /**
     *
     * @author Oriol
     * @author Fernando
     */
public class Recepta {

    private Integer id_Recepta;
    private String elaboracio;
    private String temps;
    private String nom;
    private String dificultat;
    private Xef xef;
    private Set<Plat> plats;
    private Tipus_Menjar tMenjar;
    
    private Set<Ingredient> ingredients;

    /**
     * Constructor 
     */
    public Recepta() {
        super();
	// TODO Auto-generated constructor stub
    }
    /**
     * Constructor amb diferents parametres d'entrada
     * @param elaboracio
     * @param temps
     * @param nom
     * @param dificultat
     * @param xef
     * @param tipMenjar relacionat amb la recepta
     */
    public Recepta(String elaboracio, String temps, String nom, String dificultat, Xef xef, Tipus_Menjar tipMenjar) {

        this.elaboracio = elaboracio;
        this.temps = temps;
        this.nom = nom;
        this.dificultat = dificultat;
        this.xef = xef;
        this.tMenjar = tMenjar;
        this.plats = new HashSet<Plat>();
        this.ingredients = new HashSet<Ingredient>();

    }
    /**
     *  Obtenim ingredients relacionats amb la recepta
     * @return ingredients
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
    /**
     * Afegim ingredients relacionats amb la recepta
     * @param ingredients
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    /**
     * Obteni la id de la recepta
     * @return id_Recepta integer
     */
    public Integer getId_Recepta() {
        return id_Recepta;
    }
    /**
     * Obtenim el xef relacionat amb la recepta
     * @return xef relaciont amb la recepta
     */
    public Xef getXef() {
        return xef;
    }
    /**
     *
     * @param xef afegim el xef relacionat amb la recepta
     */
    public void setXef(Xef xef) {
        this.xef = xef;
    }
    /**
     * Afegim id de la recpta
     * @param id_Recepta id de la recepta
     */
    public void setId_Recepta(Integer id_Recepta) {
        this.id_Recepta = id_Recepta;
    }
    /**
     * Obtenim string amb elaboracio de la recpta
     * @return elaboracio
     */
    public String getElaboracio() {
        return elaboracio;
    }
    /**
     * Afegim string elaboracio a la recepta
     * @param elaboracio
     */
    public void setElaboracio(String elaboracio) {
        this.elaboracio = elaboracio;
    }
    /**
     * Obtenim el temps de la recepta
     * @return temps
     */
    public String getTemps() {
        return temps;
    }
    /**
     * Afegim el temps de la recpta
     * @param temps
     */
    public void setTemps(String temps) {
        this.temps = temps;
    }
    /**
     * Obtenim el nom de la recepta
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Afegim el nom de la recepta
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Afegim la dificultat de la recepta
     * @return dificultat
     */
    public String getDificultat() {
        return dificultat;
    }
    /**
     * afegim la dificultat de la recpta
     * @param dificultat
     */
    public void setDificultat(String dificultat) {
        this.dificultat = dificultat;
    }
    /**
     * Obtenim els plats relacionats amb la recpta
     * @return plats
     */
    public Set<Plat> getPlats() {
        return plats;
    }
    /**
     * Afegim els plats relacionats amb la recpta
     * @param plats
     */
    public void setPlats(Set<Plat> plats) {
        this.plats = plats;
    }
    /**
     * Obtenim el tipus de menjar que es la recepta
     * @return tMenjar
     */
    public Tipus_Menjar gettMenjar() {
        return tMenjar;
    }
    /**
     * Afegem la relacio de la recpta amb el tipus de menjar
     * @param tMenjar
     */
    public void settMenjar(Tipus_Menjar tMenjar) {
        this.tMenjar = tMenjar;
    }
    /**
     * Afegim els tipus d'ingredients relacionats amb la recepta
     * @param ingredient
     */
    public void setIngredients(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    
    /* Class functions */

    /**
     *  Afegeix plat a plats
     * @param plat
     */
    
    public void addPlat(Plat plat) {
        this.plats.add(plat);
    }
    
    /* Class functions */

    /**
     *
     * @param ingredient
     */
    
    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
   
    
    

}
