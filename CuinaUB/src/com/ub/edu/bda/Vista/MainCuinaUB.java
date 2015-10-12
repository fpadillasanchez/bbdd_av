package com.ub.edu.bda.Vista;

import Gestions.GestionsFamiliaIngredient;
import Gestions.GestionsIngredients;
import Gestions.GestionsPlat;
import Gestions.GestionsTipusMenjar;
import Gestions.GestionsXef;
import Gestions.GestioRecepta;
import Gestions.GestionsReceptaIngredient;
import com.ub.edu.bda.Model.*;
import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
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
    
    static GestioRecepta gpRecepta = new GestioRecepta();//paquet on tenil la gestio de les diferents entitats
    static GestionsPlat gpPlat = new GestionsPlat();//paquet on tenil la gestio de les diferents entitats
    static GestionsTipusMenjar gpTMenjar = new GestionsTipusMenjar();//paquet on tenil la gestio de les diferents entitats
    static GestionsXef gfXef = new GestionsXef();//paquet on tenil la gestio de les diferents entitats
    static GestionsIngredients gIngre = new GestionsIngredients();//paquet on tenil la gestio de les diferents entitats
    static GestionsFamiliaIngredient gFamIngr = new GestionsFamiliaIngredient();//paquet on tenil la gestio de les diferents entitats
    static GestionsReceptaIngredient gRecIngre = new GestionsReceptaIngredient();
    
    static OperacionsTipusMenjar operacionsTipMenjar = new OperacionsTipusMenjar();
    static OperacionsRecepta operacionsRecepta = new OperacionsRecepta();
    static OperacionsPlat operacionsPlat = new OperacionsPlat();
    static OperacionsXef opXef = new OperacionsXef();
    static OperacionsIngredient operacionsIngredient = new OperacionsIngredient();
    static OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    // Menu de l'aplicacio
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
                    gpRecepta.menuRecepta(inputRecepta, operacionsRecepta);
                    break;

                case 2://Tipus Plat
                    
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir plat\n2-Eliminar plat\n3-Mostrar plats\n4-Actualitza plats");
                    int inputPlat = llegeixInt();
                    gpPlat.menuPlat(inputPlat, operacionsPlat);

                    break;
                case 3://Tipus Menjar
                    
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar");
                    int tipusMenjar = llegeixInt();
                    gpTMenjar.menuTipusMenjar(tipusMenjar, operacionsTipMenjar);
                    break;
                case 4://Xef
                    
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs\n4-Actualitzar xef");
                    int inputXef = llegeixInt();
                    gfXef.menuXef(inputXef, opXef);
                    break;

                case 5://Ingredient
                    
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputIngredient = llegeixInt();
                    gIngre.menuIngredient(inputIngredient, operacionsIngredient);
                    break;

                //classes adicionals per decisions de disseny    
                case 6://Familia Ingredient
                    
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir Fmilia ingredients\n2-Eliminar Fmilia ingredients\n3-Mostrar Fmilia ingredients");
                    int inputFamIngredient = llegeixInt();
                    gFamIngr.menuFamIngredient(inputFamIngredient, operacionsFamIngredient);
                    break;

                case 7: // afegir a les receptes els seus ingredients
                    gRecIngre.menuRecIng(operacionsIngredient,operacionsRecepta);
                    
            }

        }

    }
}
