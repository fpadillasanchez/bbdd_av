package com.ub.edu.bda.Model;
    /**
     *
     * @author Oriol
     * @author Fernando
     */
public class Tipus_Menjar {

    private Integer id_Tipus;
    private String nom;
    /**
     * Constructor 
     */
    public Tipus_Menjar() {
        super();
	// TODO Auto-generated constructor stub
    }
    /**
     * Constructor del tipus de menjar amb parametre nom
     * @param nom string
     */
    public Tipus_Menjar(String nom) {
        this.nom = nom;
    }
    /**
     * Obtenim la tipus de menjar
     * @return id_Tipus
     */
    public Integer getId_Tipus() {
        return id_Tipus;
    }
    /**
     * Afegim la id del tipus de menjar
     * @param id_Tipus integer
     */
    public void setId_Tipus(Integer id_Tipus) {
        this.id_Tipus = id_Tipus;
    }
    /**
     * Obtenim el nom del tipus de menjar
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Afegim el nom al tipus de menjar
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Tipus_Menjar{" + "id_Tipus=" + id_Tipus + ", nom=" + nom + '}';
    }

}
