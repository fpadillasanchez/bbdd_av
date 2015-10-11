/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestions;

import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.Recepta;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class GestioRecepta {
    
     public static void mostrarRecepta(OperacionsRecepta op) {

        List<Recepta> listaRecepta = op.getListRecepta();
        System.out.println("Tenim " + listaRecepta.size() + " Receptes");
        System.out.println("_____________________________");
        for (Recepta recepta : listaRecepta) {
            System.out.println("Nom recepta:"+recepta.getNom()+"ID:"+recepta.getId_Recepta());
        }
    }
    
}
