package com.ub.edu.bda.Vista;

import Gestions.GestionsFamiliaIngredient;
import Gestions.GestionsIngredients;
import Gestions.GestionsPlat;
import Gestions.GestionsTipusMenjar;
import Gestions.GestionsXef;
import Gestions.GestioRecepta;
import Gestions.GestionsReceptaIngredient;
import com.ub.edu.bda.Model.*;
import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.escriuLin;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import org.hibernate.Session;
import java.io.IOException;
import org.hibernate.Transaction;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Oriol
 * @author Fernando
 */
public class MainCuinaUB {
    /*
     /**
     * @param args
     */

    static Session session = null;
    static Transaction tx = null;

    static GestioRecepta gpRecepta = new GestioRecepta();//paquet on tenil la gestio de les diferents entitats
    static GestionsPlat gpPlat = new GestionsPlat();//paquet on tenil la gestio de les diferents entitats
    static GestionsTipusMenjar gpTMenjar = new GestionsTipusMenjar();//paquet on tenil la gestio de les diferents entitats
    static GestionsXef gfXef = new GestionsXef();//paquet on tenil la gestio de les diferents entitats
    static GestionsIngredients gIngre = new GestionsIngredients();//paquet on tenil la gestio de les diferents entitats
    static GestionsFamiliaIngredient gFamIngr = new GestionsFamiliaIngredient();//paquet on tenil la gestio de les diferents entitats
    static GestionsReceptaIngredient gRecIngre = new GestionsReceptaIngredient();

    static OperacionsTipusMenjar operacionsTipMenjar = new OperacionsTipusMenjar();
    static OperacionsRecepta operacionsRecepta = new OperacionsRecepta();
    static OperacionsPlat operacionsPlat = new OperacionsPlat();
    static OperacionsXef opXef = new OperacionsXef();
    static OperacionsIngredient operacionsIngredient = new OperacionsIngredient();
    static OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();
    private static final InputStreamReader imr = new InputStreamReader(System.in);
    private static final BufferedReader bfr = new BufferedReader(imr);

    /**
     * Menu principal per interactuar amb l'aplicacio
     *
     * @param args
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    // Menu de l'aplicacio
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int opcMenu = 0;

        int exitCuinaUB = -1;

        boolean logginOK = registre();
        while (exitCuinaUB != 1) {

            if (logginOK == true) {
                escriu("-------------------MENÚ PRINCIPAL CUINAUB-------------------");
                escriu("\n1-Recepta\n2-Tipus de plat\n3-Tipus de menjar\n4-Xef\n5-Ingredient\n6-Familiia ingredient");
                opcMenu = llegeixInt();

                switch (opcMenu) {
                    case 1://Recepta

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir recepta\n2-Eliminar recepta\n3-Mostrar receptes\n");
                        int inputRecepta = llegeixInt();
                        gpRecepta.menuRecepta(inputRecepta, operacionsRecepta);
                        break;

                    case 2://Tipus Plat

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir plat\n2-Eliminar plat\n3-Mostrar plats\n4-Actualitza plats\n");
                        int inputPlat = llegeixInt();
                        gpPlat.menuPlat(inputPlat, operacionsPlat);

                        break;
                    case 3://Tipus Menjar

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar\n");
                        int tipusMenjar = llegeixInt();
                        gpTMenjar.menuTipusMenjar(tipusMenjar, operacionsTipMenjar);
                        break;
                    case 4://Xef

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs\n4-Actualitzar xef\n");
                        int inputXef = llegeixInt();
                        gfXef.menuXef(inputXef, opXef);
                        break;

                    case 5://Ingredient

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes\n");
                        int inputIngredient = llegeixInt();
                        gIngre.menuIngredient(inputIngredient, operacionsIngredient);
                        break;

                    //classes adicionals per decisions de disseny    
                    case 6://Familia Ingredient

                        escriu("Accions disponibles a la base de dades\n");
                        escriu("\n1-Afegir Fmilia ingredients\n2-Eliminar Fmilia ingredients\n3-Mostrar Fmilia ingredients\n");
                        int inputFamIngredient = llegeixInt();
                        gFamIngr.menuFamIngredient(inputFamIngredient, operacionsFamIngredient);
                        break;

                    case 7: // afegir a les receptes els seus ingredients
                        gRecIngre.menuRecIng(operacionsIngredient, operacionsRecepta);
                        break;

                }

            } else {
                System.out.println("No has pogut entrar, login incorrecte,");
            }
        }
    }

    /**
     * Classe usada per controlar el login d'usuari, compara pass i nom
     *
     * @return true si el login es correcte
     * @throws HibernateException
     */
    private static boolean registre() {
        escriu("usuari:prova");
        escriu("password:1234");
        escriu("-------------------------------------\n");
        boolean ok = false;
        try {
            escriu("####Registre####");
            escriuLin("Introdueix el com: ");
            String nik = bfr.readLine();
            escriuLin("Introdueix la contrassenya: ");
            String pass = bfr.readLine();

            Session sesion = ConnectorHB.getSession();

            List<Usuari> listUser = sesion.createQuery("from Usuari").list();
            for (Usuari usuari : listUser) {
                if (usuari.getNom().equals(nik) && usuari.getPass().equals(pass)) {
                    ok = true;
                    escriu("Benvingut " + nik + "");
                    break;
                } else {
                    escriu("Login incorrecte");
                    break;
                }
            }
            sesion.close();
        } catch (IOException ioe) {
            escriu("ERROR al registre");
        }
        return ok;
    }

    /**
     * Classe usada per introduir usuari a la bbdd anulada temporalment
     *
     * @return id
     * @throws HibernateException
     */
    public static int guardarUsuari() throws HibernateException {
        Session sesion = ConnectorHB.getSession();
        Usuari usuari = new Usuari("prova", "1234");
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(usuari);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    /**
     *
     * @throws HibernateException
     */
    public static void connecta() throws HibernateException {
        Session sesion = ConnectorHB.getSession();
        sesion = ConnectorHB.getSession();
        tx = sesion.beginTransaction();
    }

    /**
     *
     * @param he
     * @throws HibernateException
     */
    public static void excepcio(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error al intentar accceder a los datos", he);
    }
}
