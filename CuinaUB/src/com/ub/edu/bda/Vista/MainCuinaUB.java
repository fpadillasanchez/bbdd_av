package com.ub.edu.bda.Vista;

import Gestions.GestionsFamiliaIngredient;
import Gestions.GestionsIngredients;
import Gestions.GestionsPlat;
import Gestions.GestionsTipusMenjar;
import Gestions.GestionsXef;
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
    static GestionsPlat gpPlat = new GestionsPlat();
    static GestionsTipusMenjar gpTMenjar = new GestionsTipusMenjar();
    static GestionsXef gfXef = new GestionsXef();
    static GestionsIngredients gIngre = new GestionsIngredients();
    static GestionsFamiliaIngredient gFamIngr = new GestionsFamiliaIngredient();

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
                    gpTMenjar.menuTipusMenjar(tipusMenjar, operacionsTipMenjar);
                    break;
                case 4://Xef
                    OperacionsXef opXef = new OperacionsXef();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs");
                    int inputXef = llegeixInt();
                    gfXef.menuXef(inputXef, opXef);
                    break;

                case 5://Ingredient
                    OperacionsIngredient operacionsIngredient = new OperacionsIngredient();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputIngredient = llegeixInt();
                    gIngre.menuIngredient(inputIngredient, operacionsIngredient);
                    break;

                //classes adicionals per decisions de disseny    
                case 6://Familia Ingredient
                    OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();
                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir Fmilia ingredients\n2-Eliminar Fmilia ingredients\n3-Mostrar Fmilia ingredients");
                    int inputFamIngredient = llegeixInt();
                    gFamIngr.menuFamIngredient(inputFamIngredient, operacionsFamIngredient);
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

        Recepta recepta = new Recepta(elaboracio, temps, nom, dificultat,null);
        int ident = operacionsRecepta.guardarRecepta(recepta);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Recepta insertat: " + ident + ",nom: " + recepta.getNom() + ",dificultat: " + recepta.getDificultat());

    }

}
