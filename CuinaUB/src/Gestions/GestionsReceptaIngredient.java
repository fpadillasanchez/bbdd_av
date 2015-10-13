/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import com.ub.edu.bda.Model.Ingredient;
import com.ub.edu.bda.Model.OperacionsIngredient;
import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.Recepta;
import java.util.List;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class GestionsReceptaIngredient {

    /**
     * Menu per interactuar sobre les Familia Ingredients
     *
     * @param operacionsRecepta instancia a operacions que es realitzen sobre la
     * taula de receptes
     * @param operacionsIngredient instancia a operacions que es realitzen sobre
     * la taula d ingredients
     *
     */
    public void menuRecIng(OperacionsIngredient operacionsIngredient, OperacionsRecepta operacionsRecepta) {
        List<Recepta> receptes = operacionsRecepta.getListRecepta();
        for (Recepta recep : receptes) {
            escriu(recep.toString());
        }
        escriu("Afegeix ingredients a la recepta escollida.");
        Recepta recepta = operacionsRecepta.getRecepta(llegeixInt());
        int input = 0;
        while (input != 1) {
            List<Ingredient> ingredients = operacionsIngredient.getListIngredients();
            for (Ingredient ingr : ingredients) {
                escriu(ingr.toString());
            }
            Ingredient ing = operacionsIngredient.getIngredient(llegeixInt());
            recepta.addIngredient(ing);
            ing.addRecepta(recepta);
            operacionsRecepta.actualitzaRecepta(recepta);
            operacionsIngredient.actualitzaIngredient(ing);
            input = llegeixInt();
        }
    }

}
