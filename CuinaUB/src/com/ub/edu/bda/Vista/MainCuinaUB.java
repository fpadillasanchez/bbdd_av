package com.ub.edu.bda.Vista;


import com.ub.edu.bda.Model.Plat;
import com.ub.edu.bda.Model.Ingredient;
import com.ub.edu.bda.Model.Familia_Ingredients;
import com.ub.edu.bda.Model.Recepta;
import com.ub.edu.bda.Model.Xef;
import com.ub.edu.bda.Model.Tipus_Menjar;
import static com.ub.edu.bda.Controlador.Consola.escriu;
import static com.ub.edu.bda.Controlador.Consola.llegeixInt;
import static com.ub.edu.bda.Controlador.Consola.llegeixString;
import com.ub.edu.bda.Model.operacionsXef;
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
    static operacionsXef oXef = new operacionsXef();

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
            escriu("\n1-Recepta\n2-Tipus de plat\n3-Tipus de menjar\n4-Xef\n5-Ingredient");
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
                case 3://Tipus Menjar

//                    escriu("Accions disponibles a la base de dades\n");
//                    escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar");
//                    int tipusMenjar = llegeixInt();
//                    menuTipusMenjar(tipusMenjar);
                case 4://Xef

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs");
                    int inputXef = llegeixInt();
                    menuXef(inputXef);

                case 5://Ingredient

//                    escriu("Accions disponibles a la base de dades\n");
//                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
//                    int inputIngredient = llegeixInt();
//                    menuIngredient(inputIngredient);
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
                mostrarPlats();//show
                break;

        }

    }
//    private static void menuTipusMenjar(int tipusMenjar) {
//
//        switch (tipusMenjar) {
//
//            case 1://add
//                addTipusMenjar();
//                break;
//
//            case 2://delete
//                break;
//
//            case 3://show
//                break;
//
//        }
//
//    }

    private static void menuXef(int inputXef) {

        switch (inputXef) {

            case 1://add
                addXef();
                break;

            case 2://delete
                
                break;

            case 3:
                mostrarXefs();//show
                break;

        }

    }

//    private static void menuIngredient(int inputIngredient) {
//
//        switch (inputIngredient) {
//
//            case 1://add
//                addIngredient();
//                break;
//
//            case 2://delete
//                break;
//
//            case 3://show
//                break;
//
//        }
//
//    }
    private static void mostrarXefs() {
        //TODO
        try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Xef");
//            System.out.println("Els Xefs son:");
//            List <Xef> xefs = session.createSQLQuery("SELECT * FROM XEF").addEntity(Xef.class).list();
//	            for(Xef xef: xefs){
//	                System.out.println(xef.getInt_Estrelles());
//                        System.out.println(xef.getNom());
                    
//            PER ARA NO FUNCIONA AQUESTA PART COMENTADA
//            for (Catalogo catalogo : listado) {
//                System.out.println("sa<sda");
//                System.out.println(catalogo.getDescripcion());
//                for (Xef xef : catalogo.getXefs()) {
//                    System.out.println(xef.toStringNomId());
//                }
//            }

        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

        private static void mostrarPlats() {
        //TODO
        try {
            
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
//            List<Catalogo> listado = new ArrayList<Catalogo>();
            Query q = session.createQuery("from Catalogo");
//            listado = q.list();
            System.out.println("Els Plats son:");
            List <Plat> plats = session.createSQLQuery("SELECT * FROM PLAT").addEntity(Plat.class).list();
	            for(Plat plat: plats)
	                System.out.println(plat.getNom());
//            PER ARA NO FUNCIONA AQUESTA PART COMENTADA
//            for (Catalogo catalogo : listado) {
//                System.out.println(catalogo.getDescripcion());
//                for (Plat plat : catalogo.getPlats()) {
//                    System.out.println(plat.getNom());
//                }
//            }

        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
//    private static void mostrarReceptes(){
//        //TODO
//        for(Recepta recepte: catalogo.getReceptes()){
//            escriu(recepte.toStringNomReceptId());
//        }
//    }
//    private static void mostrarFamilies() {
//        //TODO
//        for(Familia_Ingredients familia: catalogo.getFamiliaIngredients()){
//            escriu(familia.toStringIDNom());
//        }
//    }
    /*
    private static void addRecepToBD(Recepta recepta) {
        try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            session.save(recepta);
            tx.commit();
            System.out.println("Recepta guardat a la BD\n");
        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    */

    private static void addPlatToBD(Plat plat) {

        try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            session.save(plat);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    /*
     private static void addIngredientToBD(Ingredient ingredient) {
     try {
     session = ConnectorHB.getSession();
     tx = session.beginTransaction();
     session.save(ingredient);
     tx.commit();
     } catch (HibernateException e) {
     if (tx != null && tx.isActive()) {
     tx.rollback();
     }
     e.printStackTrace();
     } finally {
     if (session != null) {
     session.close();
     }
     }
     }
     */

    
    private static void addPlat() {
        int id_Recepta, id_Plat = 0;
        String nom, descripcio;
        
        //id_Recepta = llegeixInt();

        escriu("ID del plat automàtic.\n");
        id_Plat = 1;

        escriu("Nom del plat:\n");
        nom = llegeixString();

        escriu("Descripcio del plat");
        descripcio = llegeixString();

        Plat plat = new Plat(0, id_Plat, nom, descripcio);
        addPlatToBD(plat);
    }


    private static void addXef() {
        int int_Estrelles = 0;
        String nom;

        escriu("Quantes estrelles té el xef:\n");
        int_Estrelles = llegeixInt();

        escriu("ID del xef automàtic\n");
        //id_Xef = 0;// catalogo.getXef().size();

        escriu("Nom del xef\n");
        nom = llegeixString();

        Xef xef = new Xef(int_Estrelles, nom);
        oXef.guardarXef(xef);
        
    }

    private static void addRecepta() {
        Recepta recepta = new Recepta(null, null, null, null);
    }

    

}