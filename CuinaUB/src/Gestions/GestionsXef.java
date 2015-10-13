/*
 Aqui es gestionen les diferents activitats sobre els Xefs com borrar, actualitzar, donar d'altta i mostrar

 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.OperacionsXef;
import com.ub.edu.bda.Model.Recepta;
import com.ub.edu.bda.Model.Xef;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class GestionsXef {

    /**
     * Menu per interactuar sobre les Familia Ingredients
     *
     * @param inputXef Accio del menu que realitzem
     * @param op instancia a operacions que es realitzen sobre la taula de xef
     *
     */
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

    /**
     * Afegir xef a la bbdd
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     *
     */
    public static void addXef(OperacionsXef op) {

        int int_Estrelles = 0;
        String nom;
        Recepta rec = null;

        OperacionsRecepta recepta = new OperacionsRecepta();

        escriu("Quantes estrelles té el xef:\n");
        int_Estrelles = llegeixInt();

        escriu("Nom del xef\n");
        nom = llegeixString();
        List<Recepta> receptes = recepta.getListRecepta();

        Xef xef = new Xef(int_Estrelles, nom);
        for (Recepta recep : receptes) {
            escriu("Receptes:" + recep.getNom() + "ID:" + recep.getId_Recepta());
        }
        escriu("Receptes disonibles. Escull alguna que pertanyi al xef.");

        rec = recepta.getRecepta(llegeixInt());
//        HashSet set1 = new HashSet();
//        set1.add(rec);

        xef.addRecepta(rec);
        rec.setXef(xef);

        int ident = op.guardarXef(xef);
        int idRec = recepta.actualitzaRecepta(rec);
        recepta.actualitzaRecepta(rec);
        escriu("Recepta" + idRec + "actualitzada.");

        System.out.println("Xef insertat: " + ident + ",nom: " + xef.getNom() + ",estrellas: " + xef.getInt_Estrelles());

    }

    /**
     * Mostrar xef per pantalla
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     *
     */
    public static void mostrarXef(OperacionsXef op) {

        List<Xef> listaxefs = op.getListXef();
        escriu("Tenim " + listaxefs.size() + " xefs");
        escriu("_____________________________");
        for (Xef xef : listaxefs) {
            escriu(xef.toString());
            Set xefReceptes = op.getXefReceptes(xef.getId_Xef());
            escriu(xefReceptes.toString());
        }
    }

    /**
     * ABorrar xef de la bbdd
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     *
     */
    public static void deleteXef(OperacionsXef op) {

        mostrarXef(op);
        escriu("Escull un xef que vulgui borrar.\n");
        int idxef = llegeixInt();

        Xef xef = op.getXef(idxef);

        op.borrarXef(xef);

    }

    /**
     * Actualitzar xef a la bbdd
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     *
     */
    private static void actualizarXef(OperacionsXef op) {
        mostrarXef(op);
        escriu("Escull un xef que vulgui Actualitzar.\n");
        int idxef = llegeixInt();
        Xef xef = op.getXef(idxef);
        menuActualitzaXef(op, xef);
    }

    /**
     * Menu d'opcions d'actualitzacio del xef
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     * @param xef instancia a xef
     */
    private static void menuActualitzaXef(OperacionsXef op, Xef xef) {
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

    /**
     * Modificacio estrelles del xef
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     * @param xef instancia a xef
     */
    private static void modificarEstrelles(OperacionsXef op, Xef xef) {
        escriu("Estrelles:" + xef.getInt_Estrelles());
        escriu("Quantes estrelles actuals:");
        int estrelles = llegeixInt();
        xef.setInt_Estrelles(estrelles);
        op.actualitzaXef(xef);
    }

    /**
     * Modificacio Nom del xef
     *
     * @param op instancia a operacions que es realitzen sobre la taula de Xefs
     * @param xef instancia a xef
     */
    private static void modificarNom(OperacionsXef op, Xef xef) {
        escriu("Nom:" + xef.getInt_Estrelles());
        escriu("Nom actual:");
        String nom = llegeixString();
        xef.setNom(nom);
        op.actualitzaXef(xef);
    }

}
