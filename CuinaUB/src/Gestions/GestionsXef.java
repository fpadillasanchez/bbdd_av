/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.OperacionsXef;
import com.ub.edu.bda.Model.Recepta;
import com.ub.edu.bda.Model.Xef;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class GestionsXef {
    
    public static void menuXef(int inputXef, OperacionsXef op) {

        switch (inputXef) {

            case 1://add
                addXef(op);
                break;

            case 2://delete
                deleteXef(op);
                break;

            case 3:
                mostrarXef(op);//show
                break;

            case 4:
                actualizarXef(op);//actualitzar
                break;

        }

    }

    public static void addXef(OperacionsXef op) {

        int int_Estrelles = 0;
        String nom;
        
        OperacionsRecepta recepta = new OperacionsRecepta();
        

        escriu("Quantes estrelles té el xef:\n");
        int_Estrelles = llegeixInt();

        escriu("Nom del xef\n");
        nom = llegeixString();
        
        escriu("Receptes disonibles. Escull alguna que pertanyi al xef.");
        List<Recepta> receptes = recepta.getListRecepta();
        for(Recepta recep: receptes){
            escriu("Receptes:"+recep.getNom()+"Nom:"+recep.getId_Recepta());
        }
        
        Recepta rec = recepta.getRecepta(llegeixInt());
        HashSet set1 = new HashSet();
        set1.add(rec);
        
        

        Xef xef = new Xef(int_Estrelles, nom);
        xef.addRecepta(rec);
        rec.setXef(xef);
        int idRec = recepta.actualitzaRecepta(rec);
        escriu("Recepta"+idRec+"actualitzada.");
        
        int ident = op.guardarXef(xef);
        
        
        

        System.out.println("Xef insertat: " + ident + ",nom: " + xef.getNom() + ",estrellas: " + xef.getInt_Estrelles());
    }

    public static void mostrarXef(OperacionsXef op) {

        List<Xef> listaxefs = op.getListXef();
        System.out.println("Tenim " + listaxefs.size() + " Xefs");
        System.out.println("_____________________________");
        for (Xef xef : listaxefs) {
            System.out.println("--> Id: " + xef.getId_Xef() + ", nom: " + xef.getNom() + ", estrelles: " + xef.getInt_Estrelles());
        }
    }

    //TODO
    public static void deleteXef(OperacionsXef op) {

        mostrarXef(op);
        escriu("Escull un xef que vulgui borrar.\n");
        int idxef = llegeixInt();

        Xef xef = op.getXef(idxef);

        op.borrarXef(xef);

    }

    private static void actualizarXef(OperacionsXef op) {
        mostrarXef(op);
        escriu("Escull un xef que vulgui borrar.\n");
        int idxef = llegeixInt();
        Xef xef = op.getXef(idxef);
        menuActualitzaPlat(op, xef);
    }

    private static void menuActualitzaPlat(OperacionsXef op, Xef xef) {
        escriu("Que desitja modificar?:");
        escriu("\n1-Estrelles\n2-Nom");
        int opcio = llegeixInt();
        switch (opcio) {
            case 1://descripcio
                modificarEstrelles(op, xef);
                break;
            case 2://nom
                modificarNom(op, xef);
                break;

        }
    }

    private static void modificarEstrelles(OperacionsXef op, Xef xef) {
        escriu("Estrelles:" + xef.getInt_Estrelles());
        escriu("Quantes estrelles actuals:");
        int estrelles = llegeixInt();
        xef.setInt_Estrelles(estrelles);
        op.actualitzaXef(xef);
    }

    private static void modificarNom(OperacionsXef op, Xef xef) {
        escriu("Nom:" + xef.getInt_Estrelles());
        escriu("Nom actual:");
        String nom = llegeixString();
        xef.setNom(nom);
        op.actualitzaXef(xef);
    }

}
