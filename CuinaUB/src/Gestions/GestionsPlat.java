/*
 Aqui es gestionen les diferents activitats sobre els Plats com borrar, actualitzar, donar d'altta i mostrar

 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsPlat;
import com.ub.edu.bda.Model.Plat;
import java.util.List;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class GestionsPlat {

    /**
     * Menu per interactuar sobre les Familia Ingredients
     *
     * @param inputPlat Accio del menu que realitzem
     * @param operacionsPlat instancia a operacions que es realitzen sobre la
     * taula de ingredients
     *
     */
    public static void menuPlat(int inputPlat, OperacionsPlat operacionsPlat) {

        switch (inputPlat) {
            case 1://add
                addPlat(operacionsPlat);
                break;

            case 2://delete
                deletePlat(operacionsPlat);
                break;
            case 3:
                mostrarPlat(operacionsPlat);//show
                break;

            case 4:
                actualitzarPlat(operacionsPlat);//show
                break;

        }

    }

    /**
     * Afegir plat a la bbdd
     *
     * @param operacionsPlat instancia a operacions que es realitzen sobre la
     * taula de recepta
     *
     */
    public static void addPlat(OperacionsPlat operacionsPlat) {

        String nom, descripcio;

        escriu("Introdueix el nom del plat:\n");
        nom = llegeixString();

        escriu("Introdueix la descripció del plat\n");
        descripcio = llegeixString();

        Plat plat = new Plat(nom, descripcio, null);
        int ident = operacionsPlat.guardarPlat(plat);
        // TODO - aqui falta comprobar si se ha insertado
        escriu("Plat insertat: " + ident + ",nom: " + plat.getNom() + ",Descripcio: " + plat.getDescripcio());
    }

    /**
     * Mostrar per pantalla els Plat guardats a la bbdd
     *
     * @param operacionsPlat instancia a operacions que es realitzen sobre la
     * taula de recepta
     *
     */
    public static void mostrarPlat(OperacionsPlat operacionsPlat) {

        // llistem tots els elements de Plat
        List<Plat> listaplat = operacionsPlat.getListPlat();
        escriu("Tenim " + listaplat.size() + " Plats");
        escriu("_____________________________");
        for (Plat plat : listaplat) {
            escriu(plat.toString());
        }
    }

    /**
     * Actualitzar els Plat guardats a la bbdd
     *
     * @param operacionsPlat instancia a operacions que es realitzen sobre la
     * taula de recepta
     *
     */
    public static void actualitzarPlat(OperacionsPlat operacionsPlat) {
        escriu("Escull un plat que vulguis actualitzar.");
        List<Plat> listPlats = operacionsPlat.getListPlat();
        for (Plat plat : listPlats) {
            escriu(plat.toString());
        }
        int idPlat = llegeixInt();

        Plat plat = operacionsPlat.getPlat(idPlat);
        menuActualitzaPlat(operacionsPlat, plat);
        

    }

    /**
     * Borrar Plats guardats a la bbdd
     *
     * @param operacionsPlat instancia a operacions que es realitzen sobre la
     * taula de recepta
     *
     */
    public static void deletePlat(OperacionsPlat operacionsPlat) {
        escriu("Escull plat que vulgui borrar de la BBDD.");
        List<Plat> listPlats = operacionsPlat.getListPlat();
        for (Plat plat : listPlats) {
            escriu(plat.toString());
        }
        int idPlat = llegeixInt();

        Plat plat = operacionsPlat.getPlat(idPlat);
        operacionsPlat.borrarPlat(plat);

    }

    /**
     * Menu per opions d'actualitzacio de plat
     *
     * @param ope instancia a operacions que es realitzen sobre la taula de
     * recepta
     * @param plat instancia a Plat
     */
    public static void menuActualitzaPlat(OperacionsPlat ope, Plat plat) {
        escriu("Que desitja modificar?:");
        escriu("\n1-Descripcio\n2-Nom");
        int op = llegeixInt();
        switch (op) {
            case 1://descripcio
                modificarDescripcio(ope, plat);
                break;
            case 2://nom
                modificarNom(ope, plat);
                break;

        }
    }

    /**
     * Modificacio de descripcio del plat
     *
     * @param operacions instancia a operacions que es realitzen sobre la taula
     * de recepta
     * @param obj instancia a Plat
     */
    public static void modificarDescripcio(OperacionsPlat operacions, Object obj) {
        Plat plat = (Plat) obj;
        escriu("Descripcio original:" + plat.getDescripcio());
        escriu("Nova descripcio:\n");
        String desc = llegeixString();
        plat.setDescripcio(desc);
        operacions.actualitzaPlat(plat);
    }

    /**
     * Modificacio de nom del plat
     *
     * @param operacions instancia a operacions que es realitzen sobre la taula
     * de recepta
     * @param plat instancia a Plat
     */
    public static void modificarNom(OperacionsPlat operacions, Plat plat) {

        escriu("Nom original:" + plat.getNom());
        escriu("Nou nom:\n");
        String nom = llegeixString();
        plat.setDescripcio(nom);
        operacions.actualitzaPlat(plat);
    }

}
