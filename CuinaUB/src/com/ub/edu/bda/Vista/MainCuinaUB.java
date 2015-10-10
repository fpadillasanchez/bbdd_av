package com.ub.edu.bda.Vista;

import Gestions.GestionsPlat;
import Gestions.GestionsTipusMenjar;
import Gestions.GestionsXef;
import com.ub.edu.bda.Model.*;
import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Oriol
 * @author Fernando
 */


public class MainCuinaUB {
    /*
     /**
     * @param args
     */

    static Session session = null;
    static Transaction tx = null;
    static GestionsPlat gpPlat = new GestionsPlat();
    static GestionsTipusMenjar gpTMenjar = new GestionsTipusMenjar();
    static GestionsXef gfXef = new GestionsXef();

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int opcMenu = 0;

        int exitCuinaUB = -1;

        while (exitCuinaUB != 1) {
            escriu("Menú Principal CuinaUB");
            escriu("\n1-Recepta\n2-Tipus de plat\n3-Tipus de menjar\n4-Xef\n5-Ingredient\n6-Familiia ingredient");
            opcMenu = llegeixInt();

            switch (opcMenu) {
                case 1://Recepta

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir recepta\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputRecepta = llegeixInt();
                    menuRecepta(inputRecepta);

                case 2://Tipus Plat
                    OperacionsPlat operacionsPlat = new OperacionsPlat();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir plat\n2-Eliminar plat\n3-Mostrar plats\n4-Actualitza plats");
                    int inputPlat = llegeixInt();
                    gpPlat.menuPlat(inputPlat, operacionsPlat);
                    
                    break;
                case 3://Tipus Menjar
                    OperacionsTipusMenjar operacionsTipMenjar = new OperacionsTipusMenjar();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar");
                    int tipusMenjar = llegeixInt();
                    gpTMenjar.menuTipusMenjar(tipusMenjar,operacionsTipMenjar);
                    break;
                case 4://Xef
                    OperacionsXef opXef = new OperacionsXef();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs");
                    int inputXef = llegeixInt();
                    gfXef.menuXef(inputXef, opXef);
                    break;

                case 5://Ingredient

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputIngredient = llegeixInt();
                    menuIngredient(inputIngredient);
                    break;

                //classes adicionals per decisions de disseny    
                case 6://Familia Ingredient

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir Fmilia ingredients\n2-Eliminar Fmilia ingredients\n3-Mostrar Fmilia ingredients");
                    int inputFamIngredient = llegeixInt();
                    menuFamIngredient(inputFamIngredient);
                    break;

            }

        }

    }

    private static void menuRecepta(int inputRecepta) {
        switch (inputRecepta) {
            case 1://add
                addRecepta();
                break;
            case 2://delete
                break;
            case 3://show
                break;
        }
    }

    
    

    

    private static void menuIngredient(int inputIngredient) {
        switch (inputIngredient) {

            case 1://add
                addIngredient();
                break;

            case 2://delete
//                deleteIngredient(0);
                break;

            case 3:
                mostrarIngredient();//show
                break;

        }
    }

    private static void menuFamIngredient(int inputFamIngredient) {
        switch (inputFamIngredient) {
            case 1://add
                addFamIngredient();
                break;
            case 2://delete
                break;
            case 3:
                mostrarFamIngredient();//show
                break;
        }
    }
    
    

    private static void addRecepta() {

        OperacionsRecepta operacionsRecepta = new OperacionsRecepta();

        String nom, elaboracio, temps, dificultat;

        escriu("Nom:\n");
        nom = llegeixString();

        escriu("elaboracio\n");
        elaboracio = llegeixString();

        escriu("temps\n");
        temps = llegeixString();

        escriu("dificultat\n");
        dificultat = llegeixString();

        Recepta recepta = new Recepta(elaboracio, temps, nom, dificultat);
        int ident = operacionsRecepta.guardarRecepta(recepta);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Recepta insertat: " + ident + ",nom: " + recepta.getNom() + ",dificultat: " + recepta.getDificultat());

    }

   

    private static void addIngredient() {
        OperacionsIngredient operacionsIngredient = new OperacionsIngredient();

        String nom, familia, refrigeracio;

        escriu("Nom:\n");
        nom = llegeixString();

        escriu("familia:\n");
        familia = llegeixString();

        escriu("refrigeracio:\n");
        refrigeracio = llegeixString();

        Ingredient ingredient = new Ingredient(refrigeracio, familia, nom);
        int ident = operacionsIngredient.guardarIngredient(ingredient);

        System.out.println("Ingredient: " + ident + ",nom: " + ingredient.getNom());

    }

    private static void mostrarIngredient() {
        OperacionsIngredient operacionsIngredient = new OperacionsIngredient();
        // TODO FALTA DEMANAR SI MOSTREM UN O VARIS XEFS
        // Llistem tots els elements de Xef
        List<Ingredient> listaingredients = operacionsIngredient.getListIngredients();
        System.out.println("Tenim " + listaingredients.size() + " Xefs");
        System.out.println("_____________________________");
        for (Ingredient ingredient : listaingredients) {
            System.out.println("--> Id: " + ingredient.getId_Ingredient() + ", nom: " + ingredient.getNom() + ", Refrigeracio: " + ingredient.getRefrigeracio() + ", Familia: " + ingredient.getFamilia());
        }
    }

    private static void addFamIngredient() {
        OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();

        String nom, descripcio;

        escriu("Familia:\n");
        nom = llegeixString();

        escriu("Descripcio:\n");
        descripcio = llegeixString();

        Familia_Ingredients famIngredient = new Familia_Ingredients(descripcio, nom);
        int ident = operacionsFamIngredient.guardarFamIngredient(famIngredient);

        System.out.println("Familia: " + ident + ",Descripcio: " + famIngredient.getnom());
    }

    private static void mostrarFamIngredient() {
        OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();
        // TODO FALTA DEMANAR SI MOSTREM UN O VARIS XEFS
        // Llistem tots els elements de Xef
        List<Familia_Ingredients> listaFamingredients = operacionsFamIngredient.getListFamIngredients();
        System.out.println("Tenim " + listaFamingredients.size() + " Xefs");
        System.out.println("_____________________________");
        for (Familia_Ingredients Famingredient : listaFamingredients) {
            System.out.println("--> Id: " + Famingredient.getId_familiaIngredients() + ", nom: " + Famingredient.getNom() + ", Descripcio: " + Famingredient.getDescripcio());
        }
    }

    

   

}
