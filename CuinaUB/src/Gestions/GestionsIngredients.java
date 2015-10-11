/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.Ingredient;
import com.ub.edu.bda.Model.OperacionsIngredient;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class GestionsIngredients {

    public static void menuIngredient(int inputIngredient, OperacionsIngredient operacionsIngredient) {
        switch (inputIngredient) {

            case 1://add
                addIngredient(operacionsIngredient);
                break;

            case 2://delete
                deleteIngredient(operacionsIngredient);
                break;

            case 3:
                mostrarIngredient(operacionsIngredient);//show
                break;

            case 4:
                actualitzarIngredient(operacionsIngredient);//show
                break;

        }
    }

    public static void addIngredient(OperacionsIngredient operacionsIngredient) {

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

    public static void mostrarIngredient(OperacionsIngredient operacionsIngredient) {

        // Llistem tots els elements de Xef
        List<Ingredient> listaingredients = operacionsIngredient.getListIngredients();
        System.out.println("Tenim " + listaingredients.size() + " Xefs");
        System.out.println("_____________________________");
        for (Ingredient ingredient : listaingredients) {
            System.out.println("--> Id: " + ingredient.getId_Ingredient() + ", nom: " + ingredient.getNom() + ", Refrigeracio: " + ingredient.getRefrigeracio() + ", Familia: " + ingredient.getFamilia());
        }
    }

    private static void deleteIngredient(OperacionsIngredient operacionsIngredient) {

        mostrarIngredient(operacionsIngredient);
        escriu("Quin ingredient vols borrar.");
        Ingredient ingredient = operacionsIngredient.getIngredient(llegeixInt());
        operacionsIngredient.borrarIngredient(ingredient);
    }

    private static void actualitzarIngredient(OperacionsIngredient operacionsIngredient) {
        mostrarIngredient(operacionsIngredient);
        Ingredient ingredient = operacionsIngredient.getIngredient(llegeixInt());
        menuActualitzaIngredient(operacionsIngredient, ingredient);

    }

    private static void menuActualitzaIngredient(OperacionsIngredient ope, Ingredient ingr) {
        escriu("Que desitja modificar?:");
        escriu("\n1-Refrigeracio\n2-Familia\n3-Nom");
        int opcio = llegeixInt();

        switch (opcio) {

            case 1://Refrigeracio
                modificarRefrigeracio(ope, ingr);
            case 2://Familia
                modificarFamilia(ope, ingr);
            case 3: //Nom
                modificarNom(ope, ingr);

        }
    }

    private static void modificarRefrigeracio(OperacionsIngredient ope, Ingredient ingr) {
        escriu("Refrigeracio:" + ingr.getRefrigeracio());
        escriu("Refrigeracio?");
        ingr.setRefrigeracio(llegeixString());
        ope.actualitzaIngredient(ingr);
    }

    private static void modificarFamilia(OperacionsIngredient ope, Ingredient ingr) {
        escriu("Familia:" + ingr.getRefrigeracio());
        escriu("Familia?");
        ingr.setRefrigeracio(llegeixString());
        ope.actualitzaIngredient(ingr);
    }

    private static void modificarNom(OperacionsIngredient ope, Ingredient ingr) {
        escriu("Nom:" + ingr.getRefrigeracio());
        escriu("Nou nom:");
        ingr.setNom(llegeixString());
        ope.actualitzaIngredient(ingr);
    }

}