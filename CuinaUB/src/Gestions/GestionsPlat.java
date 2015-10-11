/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 */
public class GestionsPlat {

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

    /*
     private static void addRecepta() {

     }*/
    public static void addPlat(OperacionsPlat operacionsPlat) {

        String nom, descripcio;

        escriu("Introdueix el nom del plat:\n");
        nom = llegeixString();

        escriu("Introdueix la descripció del plat\n");
        descripcio = llegeixString();

        Plat plat = new Plat(nom, descripcio,null);
        int ident = operacionsPlat.guardarPlat(plat);
        // TODO - aqui falta comprobar si se ha insertado
        System.out.println("Plat insertat: " + ident + ",nom: " + plat.getNom() + ",Descripcio: " + plat.getDescripcio());
    }

    public static void mostrarPlat(OperacionsPlat operacionsPlat) {

        // llistem tots els elements de Plat
        List<Plat> listaplat = operacionsPlat.getListPlat();
        System.out.println("Tenim " + listaplat.size() + " Plats");
        System.out.println("_____________________________");
        for (Plat plat : listaplat) {
            System.out.println("--> Id: " + plat.getId_Plat() + ", nom: " + plat.getNom() + ", descripcio: " + plat.getDescripcio());
        }
    }

    public static void actualitzarPlat(OperacionsPlat operacionsPlat) {
        escriu("Escull un plat que vulguis actualitzar.");
        List<Plat> listPlats = operacionsPlat.getListPlat();
        for (Plat plat : listPlats) {
            System.out.println(plat.toString());
        }
        int idPlat = llegeixInt();

        Plat plat = operacionsPlat.getPlat(idPlat);
        menuActualitzaPlat(operacionsPlat, plat);
        //operacionsPlat.actualitzaPlat(plat);

    }

    public static void deletePlat(OperacionsPlat operacionsPlat) {
        escriu("Escull plat que vulgui borrar de la BBDD.");
        List<Plat> listPlats = operacionsPlat.getListPlat();
        for (Plat plat : listPlats) {
            System.out.println(plat.toString());
        }
        int idPlat = llegeixInt();

        Plat plat = operacionsPlat.getPlat(idPlat);
        operacionsPlat.borrarPlat(plat);

    }

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

    public static void modificarDescripcio(OperacionsPlat operacions, Object obj) {
        Plat plat = (Plat) obj;
        escriu("Descripcio original:" + plat.getDescripcio());
        escriu("Nova descripcio:\n");
        String desc = llegeixString();
        plat.setDescripcio(desc);
        operacions.actualitzaPlat(plat);
    }

    public static void modificarNom(OperacionsPlat operacions, Plat plat) {

        escriu("Nom original:" + plat.getNom());
        escriu("Nou nom:\n");
        String nom = llegeixString();
        plat.setDescripcio(nom);
        operacions.actualitzaPlat(plat);
    }

}
