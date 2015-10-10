package com.ub.edu.bda.Vista;

import com.ub.edu.bda.Model.OperacionsIngredient;
import com.ub.edu.bda.Model.*;
import com.ub.edu.bda.Model.Tipus_Menjar;
import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class MainCuinaUB {
    /*
     /**
     * @param args
     */

    static Session session = null;
    static Transaction tx = null;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /* Xef art = new Xef(1,1,"Lavadora AEG",catalogo);
	        
         try {
         session = ConnectorHB.getSession();
         tx = session.beginTransaction();
         session.save(art);
         tx.commit();
         //El objecto art esta enlazado
	           
         art.setDescripcion("Seat Leon"); //Esto se modificara en la BD no los datos iniciales.
         
	            
         List<Catalogo> listado = new ArrayList<Catalogo>();
         Query q = session.createQuery("from Catalogo");
         listado = q.list();
	            
         for (Catalogo catalogo : listado) {
         System.out.println(catalogo.getDescripcion());
         for(Articulo articulo: catalogo.getArticulos())
         System.out.println(articulo.getDescripcion());
         }
         System.out.println("Proceso finalizado...");
         //US DE QUERY SQL PER TROBAR OBJECTES
         List <Articulo> articulos = session.createSQLQuery("SELECT * FROM ARTICULO").addEntity(Articulo.class).list();
         for(Articulo articulo: articulos)
         System.out.println(articulo.getDescripcion());
	            
         //PER TROBAR UN OBJECTE EN CONCRET
         Query q1= session.createSQLQuery("SELECT descripcion from ARTICULO WHERE ID=1").addScalar("descripcion",StringType.INSTANCE);
         System.out.println("HE OBTINGUT LA DESCRIPCIO: "+q1.list().get(0));
	           
         } catch (HibernateException e) {
         if(tx!=null && tx.isActive()) tx.rollback();
         e.printStackTrace();
         } finally {
         if(session!=null) session.close();
         }*/
        int opcMenu = 0;

        int exitCuinaUB = -1;

        while (exitCuinaUB != 1) {
            escriu("Menú Principal CuinaUB");
            escriu("\n1-Recepta\n2-Tipus de plat\n3-Tipus de menjar\n4-Xef\n5-Ingredient\n6-Familiia ingredient");
            opcMenu = llegeixInt();

            switch (opcMenu) {
                case 1://Recepta

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir recepta\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputRecepta = llegeixInt();
                    menuRecepta(inputRecepta);

                case 2://Tipus Plat

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir plat\n2-Eliminar plat\n3-Mostrar plats");
                    int inputPlat = llegeixInt();
                    menuPlat(inputPlat);
                    break;
                case 3://Tipus Menjar

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar");
                    int tipusMenjar = llegeixInt();
                    menuTipusMenjar(tipusMenjar);
                    break;
                case 4://Xef

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs");
                    int inputXef = llegeixInt();
                    menuXef(inputXef);
                    break;

                case 5://Ingredient

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputIngredient = llegeixInt();
                    menuIngredient(inputIngredient);
                    break;
                    
                //classes adicionals per decisions de disseny    
                case 6://Familia Ingredient

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputFamIngredient = llegeixInt();
                    menuFamIngredient(inputFamIngredient);    
                    break;
                    
            }

        }

    }

    private static void menuRecepta(int inputRecepta) {
        switch (inputRecepta) {
            case 1://add
                addRecepta();
                break;
            case 2://delete
                break;
            case 3://show
                break;
        }
    }

    private static void menuPlat(int inputPlat) {
        switch (inputPlat) {
            case 1://add
                addPlat();
                break;

            case 2://delete
                break;
            case 3:
                mostrarPlat();//show
                break;

        }

    }

    private static void menuTipusMenjar(int tipusMenjar) {

        switch (tipusMenjar) {

            case 1://add
                addTipusMenjar();
                break;

            case 2://delete
                break;
            case 3://show
                break;

        }

    }

    private static void menuXef(int inputXef) {

        switch (inputXef) {

            case 1://add
                addXef();
                break;

            case 2://delete
                deleteXef(0);
                break;

            case 3:
                mostrarXef();//show
                break;

        }

    }
    /*
     private static void addRecepta() {

     }*/

    private static void addPlat() {
        OperacionsPlat operacionsPlat = new OperacionsPlat();

        String nom, descripcio;

        escriu("Introdueix el nom del plat:\n");
        nom = llegeixString();

        escriu("Introdueix la descripció del plat\n");
        descripcio = llegeixString();

        Plat plat = new Plat(nom, descripcio);
        int ident = operacionsPlat.guardarPlat(plat);
        // TODO - aqui falta comprobar si se ha insertado
        System.out.println("Plat insertat: " + ident + ",nom: " + plat.getNom() + ",Descripcio: " + plat.getDescripcio());
    }

    private static void mostrarPlat() {
        OperacionsPlat operacionsPlat = new OperacionsPlat();
        // llistem tots els elements de Plat
        List<Plat> listaplat = operacionsPlat.getListPlat();
        System.out.println("Tenim " + listaplat.size() + " Plats");
        System.out.println("_____________________________");
        for (Plat plat : listaplat) {
            System.out.println("--> Id: " + plat.getId_Plat() + ", nom: " + plat.getNom() + ", descripcio: " + plat.getDescripcio());
        }
    }
//    private static void addIngredient() {

//    }
//    private static void addTipusMenjar() {
//    }
    private static void addXef() {
        OperacionsXef operacionsXef = new OperacionsXef();
        int int_Estrelles, id_Xef = 0;
        String nom;

        escriu("Quantes estrelles té el xef:\n");
        int_Estrelles = llegeixInt();

        escriu("Nom del xef\n");
        nom = llegeixString();

        Xef xef = new Xef(int_Estrelles, nom);
        int ident = operacionsXef.guardarXef(xef);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Xef insertat: " + ident + ",nom: " + xef.getNom() + ",estrellas: " + xef.getInt_Estrelles());
    }

    private static void mostrarXef() {
        OperacionsXef operacionsXef = new OperacionsXef();
        // TODO FALTA DEMANAR SI MOSTREM UN O VARIS XEFS
        // Llistem tots els elements de Xef
        List<Xef> listaxefs = operacionsXef.getListXef();
        System.out.println("Tenim " + listaxefs.size() + " Xefs");
        System.out.println("_____________________________");
        for (Xef xef : listaxefs) {
            System.out.println("--> Id: " + xef.getId_Xef() + ", nom: " + xef.getNom() + ", estrelles: " + xef.getInt_Estrelles());
        }
    }

    //TODO
    private static void deleteXef(int idXef) {

    }

    private static void addRecepta() {

        OperacionsRecepta operacionsRecepta = new OperacionsRecepta();

        String nom, elaboracio, temps, dificultat;

        escriu("Nom:\n");
        nom = llegeixString();

        escriu("elaboracio\n");
        elaboracio = llegeixString();

        escriu("temps\n");
        temps = llegeixString();

        escriu("dificultat\n");
        dificultat = llegeixString();

        Recepta recepta = new Recepta(elaboracio, temps, nom, dificultat);
        int ident = operacionsRecepta.guardarRecepta(recepta);
        // TODO FALTA MIRAR SI REALMENT S'HA INSERTAT
        System.out.println("Recepta insertat: " + ident + ",nom: " + recepta.getNom() + ",dificultat: " + recepta.getDificultat());

    }

    private static void addTipusMenjar() {
        OperacionsTipusMenjar operacionsTipusMenjar = new OperacionsTipusMenjar();

        String nom;

        escriu("Nom:\n");
        nom = llegeixString();

        Tipus_Menjar tipus_Menjar = new Tipus_Menjar(nom);
        int ident = operacionsTipusMenjar.guardarTipusMenjar(tipus_Menjar);
               
        System.out.println("Tipus Menjar insertat: " + ident + ",nom: " + tipus_Menjar.getNom() );

    }

    private static void menuIngredient(int inputIngredient) {
        switch (inputIngredient) {

            case 1://add
                addIngredient();
                break;

            case 2://delete
                deleteXef(0);
                break;

            case 3:
                mostrarXef();//show
                break;

        }
    }

    private static void addIngredient() {
        OperacionsIngredient operacionsIngredient = new OperacionsIngredient();

        String nom,familia,refrigeracio;

        escriu("Nom:\n");
        nom = llegeixString();
        
        escriu("familia:\n");
        familia = llegeixString();
        
         escriu("refrigeracio:\n");
        refrigeracio = llegeixString();

        Ingredient ingredient = new Ingredient(refrigeracio, familia, nom);
        int ident = operacionsIngredient.guardarIngredient(ingredient);
               
        System.out.println("Ingredient: " + ident + ",nom: " + ingredient.getNom());
        
    }

    private static void menuFamIngredient(int inputFamIngredient) {
        switch (inputFamIngredient) {
            case 1://add
                addFamIngredient();
                break;
            case 2://delete
                break;
            case 3://show
                break;
        }
    }

    private static void addFamIngredient() {
        OperacionsFamIngredient operacionsFamIngredient = new OperacionsFamIngredient();

        String nom,descripcio;

        escriu("Nom:\n");
        nom = llegeixString();
        
        escriu("familia:\n");
        descripcio = llegeixString();
        
         

        Familia_Ingredients famIngredient = new Familia_Ingredients(descripcio, nom);
        int ident = operacionsFamIngredient.guardarFamIngredient(famIngredient);
               
        System.out.println("Ingredient: " + ident + ",nom: " + famIngredient.getnom());
    }

}
