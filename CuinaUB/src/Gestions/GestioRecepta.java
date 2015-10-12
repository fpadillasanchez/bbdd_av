/*
 Aqui es gestionen les diferents activitats sobre les receptes com borrar, actualitzar, donar d'altta i mostrar
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsPlat;
import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.Plat;
import com.ub.edu.bda.Model.Recepta;
import java.util.List;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class GestioRecepta {

    public void menuRecepta(int inputRecepta, OperacionsRecepta op) {
        switch (inputRecepta) {
            case 1://add
                addRecepta(op);
                break;
            case 2:
                deleteRecepta(op);//delete
                break;
            case 3:
                mostrarRecepta(op);//show
                break;

            case 4: //actualizar
                actualitzarRecepta(op);//show
                break;
        }
    }

    public static void mostrarRecepta(OperacionsRecepta op) {

        List<Recepta> listaRecepta = op.getListRecepta();
        System.out.println("Tenim " + listaRecepta.size() + " Receptes");
        System.out.println("_____________________________");
        for (Recepta recepta : listaRecepta) {
            System.out.println("Nom recepta:" + recepta.getNom() + " ID:" + recepta.getId_Recepta() + " Elaboracio:" + recepta.getElaboracio() + " Temps:" + recepta.getTemps() + " Dificultat:" + recepta.getDificultat());
        }
    }

    private static void addRecepta(OperacionsRecepta operacionsRecepta) {

        Plat plat;
        String nom, elaboracio, temps, dificultat;
        OperacionsPlat plats = new OperacionsPlat();

        escriu("Nom:\n");
        nom = llegeixString();

        escriu("elaboracio\n");
        elaboracio = llegeixString();

        escriu("temps\n");
        temps = llegeixString();

        escriu("dificultat\n");
        dificultat = llegeixString();

        Recepta recepta = new Recepta(elaboracio, temps, nom, dificultat, null, null);

        List<Plat> listPlats = plats.getListPlat();
        for (Plat pla : listPlats) {
            escriu(pla.toString());
        }
        escriu("Escull el plat corresponent a la recepta.");
        plat = plats.getPlat(llegeixInt());

        recepta.addPlat(plat);
        plat.setId_Recepta(recepta.getId_Recepta());

        int ident = operacionsRecepta.guardarRecepta(recepta);
        plats.actualitzaPlat(plat);
        plats.actualitzaPlat(plat);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Recepta insertat: " + ident + ",nom: " + recepta.getNom() + ",dificultat: " + recepta.getDificultat());

    }

    public static void deleteRecepta(OperacionsRecepta op) {
        List<Recepta> listaRecepta = op.getListRecepta();
        for (Recepta recepta : listaRecepta) {
            System.out.println("Nom recepta:" + recepta.getNom() + " ID:" + recepta.getId_Recepta());
        }
        escriu("Escull la recepta que vulgui borrar de la BBDD.");
        int idRecepta = llegeixInt();

        Recepta recepta = op.getRecepta(idRecepta);
        op.borrarRecepta(recepta);

    }

    private void actualitzarRecepta(OperacionsRecepta op) {
        mostrarRecepta(op);
        escriu("Escriu la recepta que vulgui actualizar.");
        Recepta recepta = op.getRecepta(llegeixInt());
        menuRecepta(op, recepta);
    }

    private void menuRecepta(OperacionsRecepta op, Recepta recepta) {
        /*
         this.elaboracio = elaboracio;
         this.temps = temps;
         this.nom = nom;
         this.dificultat = dificultat;
         */

        escriu("Que desitja modificar?:");
        escriu("\n1-Estrelles\n2-Nom");
        int opcio = llegeixInt();
        switch (opcio) {
            case 1://elaboracio
                modificarElaboracio(op, recepta);
                break;
            case 2://temps
                modificarTemps(op, recepta);
                break;

            case 3://elaboracio
                modificarNom(op, recepta);
                break;
            case 4://temps
                modificarDificultat(op, recepta);
                break;

        }

    }

    private void modificarElaboracio(OperacionsRecepta op, Recepta recepta) {
        escriu("Elaboracio:" + recepta.getElaboracio());
        escriu("Quantes estrelles actuals:");
        recepta.setElaboracio(llegeixString());
        op.actualitzaRecepta(recepta);
        
    }

    private void modificarTemps(OperacionsRecepta op, Recepta recepta) {
        escriu("Temps:" + recepta.getTemps());
        escriu("Temps actuals:");
        recepta.setTemps(llegeixString());
        op.actualitzaRecepta(recepta);
        
    }

    private void modificarNom(OperacionsRecepta op, Recepta recepta) {
         escriu("Nom:" + recepta.getNom());
        escriu("Nom actuals:");
        recepta.setElaboracio(llegeixString());
        op.actualitzaRecepta(recepta);
        
    }

    private void modificarDificultat(OperacionsRecepta op, Recepta recepta) {
        escriu("Dificultat:" + recepta.getDificultat());
        escriu("Dificultat actuals:");
        recepta.setDificultat(llegeixString());
        op.actualitzaRecepta(recepta);
    }

}
