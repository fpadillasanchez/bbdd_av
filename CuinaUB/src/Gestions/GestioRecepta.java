/*
Aqui es gestionen les diferents activitats sobre les receptes com borrar, actualitzar, donar d'altta i mostrar
 */
package Gestions;

import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.OperacionsRecepta;
import com.ub.edu.bda.Model.Recepta;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class GestioRecepta {
    public void menuRecepta(int inputRecepta, OperacionsRecepta operacionsRecepta) {
        switch (inputRecepta) {
            case 1://add
                addRecepta(operacionsRecepta);
                break;
            case 2:
                deleteRecepta(operacionsRecepta);//delete
                break;
            case 3:
                mostrarRecepta(operacionsRecepta);//show
                break;
        }
    }   
     public static void mostrarRecepta(OperacionsRecepta op) {

        List<Recepta> listaRecepta = op.getListRecepta();
        System.out.println("Tenim " + listaRecepta.size() + " Receptes");
        System.out.println("_____________________________");
        for (Recepta recepta : listaRecepta) {
            System.out.println("Nom recepta:"+recepta.getNom()+" ID:"+recepta.getId_Recepta());
        }
    }

    private static void addRecepta(OperacionsRecepta operacionsRecepta) {



        String nom, elaboracio, temps, dificultat;

        escriu("Nom:\n");
        nom = llegeixString();

        escriu("elaboracio\n");
        elaboracio = llegeixString();

        escriu("temps\n");
        temps = llegeixString();

        escriu("dificultat\n");
        dificultat = llegeixString();

        Recepta recepta = new Recepta(elaboracio, temps, nom, dificultat,null,null);
        int ident = operacionsRecepta.guardarRecepta(recepta);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Recepta insertat: " + ident + ",nom: " + recepta.getNom() + ",dificultat: " + recepta.getDificultat());

    }    

     public static void deleteRecepta(OperacionsRecepta op) {
        List<Recepta> listaRecepta = op.getListRecepta();
        for (Recepta recepta : listaRecepta) {
            System.out.println("Nom recepta:"+recepta.getNom()+" ID:"+recepta.getId_Recepta());
        }
        escriu("Escull la recepta que vulgui borrar de la BBDD.");
        int idRecepta = llegeixInt();

        Recepta recepta = op.getRecepta(idRecepta);
        op.borrarRecepta(recepta);

    }   
 
}
