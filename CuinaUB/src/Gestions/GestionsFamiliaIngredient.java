/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.Familia_Ingredients;

import com.ub.edu.bda.Model.OperacionsFamIngredient;

import java.util.List;

/**
 *
 * @author Fernando
 */
public class GestionsFamiliaIngredient {

    public void menuFamIngredient(int inputFamIngredient, OperacionsFamIngredient operacionsFamIngredient) {
        switch (inputFamIngredient) {
            case 1://add
                addFamIngredient(operacionsFamIngredient);
                break;
            case 2://delete

                deleteFamIngredient(operacionsFamIngredient);
                break;
            case 3:
                mostrarFamIngredient(operacionsFamIngredient);//show
                break;

            case 4:
                actualitzarFamIngredient(operacionsFamIngredient);//show
                break;
        }
    }

    private static void addFamIngredient(OperacionsFamIngredient operacionsFamIngredient) {

        String nom, descripcio;

        escriu("Familia:\n");
        nom = llegeixString();

        escriu("Descripcio:\n");
        descripcio = llegeixString();

        Familia_Ingredients famIngredient = new Familia_Ingredients(descripcio, nom);
        int ident = operacionsFamIngredient.guardarFamIngredient(famIngredient);

        System.out.println("Familia: " + ident + ",Descripcio: " + famIngredient.getnom());
    }

    private static void mostrarFamIngredient(OperacionsFamIngredient operacionsFamIngredient) {

        // TODO FALTA DEMANAR SI MOSTREM UN O VARIS XEFS
        // Llistem tots els elements de Xef
        List<Familia_Ingredients> listaFamingredients = operacionsFamIngredient.getListFamIngredients();
        System.out.println("Tenim " + listaFamingredients.size() + " Xefs");
        System.out.println("_____________________________");
        for (Familia_Ingredients Famingredient : listaFamingredients) {
            System.out.println("--> Id: " + Famingredient.getId_familiaIngredients() + ", nom: " + Famingredient.getNom() + ", Descripcio: " + Famingredient.getDescripcio());
        }
    }

    private void deleteFamIngredient(OperacionsFamIngredient operacionsFamIngredient) {
        mostrarFamIngredient(operacionsFamIngredient);
        escriu("Escull la familia dingredients");
        Familia_Ingredients fmIngredient = operacionsFamIngredient.getFamIngredient(llegeixInt());
        operacionsFamIngredient.borrarFamIngredient(fmIngredient);
    }

    private void actualitzarFamIngredient(OperacionsFamIngredient operacionsFamIngredient) {
        mostrarFamIngredient(operacionsFamIngredient);
        Familia_Ingredients famIngredient = operacionsFamIngredient.getFamIngredient(llegeixInt());
        menuActualitzaIngredient(operacionsFamIngredient, famIngredient);
    }

    private void menuActualitzaIngredient(OperacionsFamIngredient ope, Familia_Ingredients famIng) {
        escriu("Que desitja modificar?:");
        escriu("\n1-Familia\n2-Descripcio");
        int opcio = llegeixInt();

        switch (opcio) {

            case 1://Refrigeracio
                modificarFamilia(ope, famIng);
            case 2://Familia
                modificarDescripcio(ope, famIng);

        }
    }

    private void modificarFamilia(OperacionsFamIngredient ope, Familia_Ingredients famIng) {
        escriu("Familia:" + famIng.getDescripcio());
        escriu("Familia?");
        famIng.setDescripcio(llegeixString());
        ope.actualitzaFamIngredient(famIng);
    }

    private void modificarDescripcio(OperacionsFamIngredient ope, Familia_Ingredients famIng) {
        escriu("Descripcio:" + famIng.getDescripcio());
        escriu("Familia?");
        famIng.setDescripcio(llegeixString());
        ope.actualitzaFamIngredient(famIng);
    }

}