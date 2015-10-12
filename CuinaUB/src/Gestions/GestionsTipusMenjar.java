/*
Aqui es gestionen les diferents activitats sobre el TipoMenjar com borrar, actualitzar, donar d'altta i mostrar

 */
package Gestions;


import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsTipusMenjar;
import com.ub.edu.bda.Model.Tipus_Menjar;
import java.util.List;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class GestionsTipusMenjar {

    public static void menuTipusMenjar(int tipusMenjar, OperacionsTipusMenjar op) {

        switch (tipusMenjar) {

            case 1://add
                addTipusMenjar(op);
                break;

            case 2://delete
                deleteTipusMenjar(op);
                break;
            case 3:
                mostrarTipusMenjar(op);
                //show
                break;

            case 4:
                actualitzarTipusMenjar(op);
                //show
                break;

        }

    }

    public static void addTipusMenjar(OperacionsTipusMenjar op) {

        String nom;

        escriu("Nom:\n");
        nom = llegeixString();

        Tipus_Menjar tipus_Menjar = new Tipus_Menjar(nom);
        op.guardarTipusMenjar(tipus_Menjar);

    }

    public static void mostrarTipusMenjar(OperacionsTipusMenjar op) {

        // TODO FALTA DEMANAR SI MOSTREM UN O VARIS XEFS
        // Llistem tots els elements de Xef
        List<Tipus_Menjar> listaTipusMenjar = op.getListTipus_Menjars();
        System.out.println("Tenim " + listaTipusMenjar.size() + " Xefs");
        System.out.println("_____________________________");
        for (Tipus_Menjar tipus_Menjar : listaTipusMenjar) {
            System.out.println("--> Id: " + tipus_Menjar.getId_Tipus() + ", nom: " + tipus_Menjar.getNom());
        }
    }

    private static void deleteTipusMenjar(OperacionsTipusMenjar op) {
        escriu("Escull plat que vulgui borrar de la BBDD.");
        List<Tipus_Menjar> listTMenjar = op.getListTipus_Menjars();
        for (Tipus_Menjar tipMenjar : listTMenjar) {
            System.out.println(tipMenjar.toString());
        }
        int idTipMenjar = llegeixInt();

        Tipus_Menjar tipMenjar = op.getTipusMenjar(idTipMenjar);
        op.borrarTipusMenjar(tipMenjar);
    }

    private static void menuModificarTipusMenjar(OperacionsTipusMenjar op, Tipus_Menjar tipMenjar) {
        escriu("Nom original:" + tipMenjar.getNom());
        escriu("Nou nom");
        String nom = llegeixString();

        tipMenjar.setNom(nom);
        op.actualitzaTipusMenjar(tipMenjar);

    }

    private static void actualitzarTipusMenjar(OperacionsTipusMenjar op) {
        mostrarTipusMenjar(op);
        int idTipMenjar = llegeixInt();

        Tipus_Menjar tipMenjar = op.getTipusMenjar(idTipMenjar);
        menuModificarTipusMenjar(op, tipMenjar);
        //operacionsPlat.actualitzaPlat(plat);

    }

}
