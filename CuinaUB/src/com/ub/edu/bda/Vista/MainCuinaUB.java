package com.ub.edu.bda.Vista;

import com.ub.edu.bda.Model.Catalogo;
import com.ub.edu.bda.Model.Plat;
import com.ub.edu.bda.Model.Ingredient;
import com.ub.edu.bda.Model.Familia_Ingredients;
import com.ub.edu.bda.Model.Recepta;
import com.ub.edu.bda.Model.Xef;
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
import org.hibernate.type.StringType;

public class MainCuinaUB {
    /*
     /**
     * @param args
     */

    static Catalogo catalogo = new Catalogo();
    static Session session = null;
    static Transaction tx = null;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
		// TODO Auto-generated method stub

        /*
         Articulo art = new Articulo("Lavadora AEG", 23.4);
	        
         try {
         session = ConnectorHB.getSession();
         tx = session.beginTransaction();
         session.save(art);
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
         }

         }
        */
         
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

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir tipus de menjar\n2-Eliminar tipus de menjar\n3-Mostrar tipus de menjar");
                    int tipusMenjar = llegeixInt();
                    menuTipusMenjar(tipusMenjar);

                case 4://Xef

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir xef\n2-Eliminar xef\n3-Mostrar xefs");
                    int inputXef = llegeixInt();
                    menuXef(inputXef);

                case 5://Ingredient

                    escriu("Accions disponibles a la base de dades\n");
                    escriu("\n1-Afegir ingredient\n2-Eliminar recepta\n3-Mostrar receptes");
                    int inputIngredient = llegeixInt();
                    menuIngredient(inputIngredient);
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

            case 3://show
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
                break;

            case 3://show
                break;

        }

    }

    private static void menuIngredient(int inputIngredient) {

        switch (inputIngredient) {

            case 1://add
                addIngredient();
                break;

            case 2://delete
                break;

            case 3://show
                break;

        }

    }
    
    private static void mostrarXefs() {
        //TODO
        for (Xef xef : catalogo.getXef()) {
            escriu(xef.getId_Xef());
        }
    }
    
    private static void mostrarReceptes(){
        //TODO
        for(Recepta recepte: catalogo.getReceptes()){
            escriu(recepte.toStringNomReceptId());
        }
    }
    
    private static void mostrarFamilies() {
        //TODO
        for(Familia_Ingredients familia: catalogo.getFamiliaIngredients()){
            escriu(familia.toStringIDNom());
        }
    }

      private static void addRecepToBD(Recepta recepta) {

        try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            session.save(recepta);
            tx.commit();
            catalogo.getReceptes().add(recepta);
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
     
     private static void addXefToBD(Xef xef) {
        
        try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            session.save(xef);
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
     
     private static void addTipusMenjar(Tipus_Menjar tM) {
         try {
            session = ConnectorHB.getSession();
            tx = session.beginTransaction();
            session.save(tM);
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
     
    /**
     *
     */
    private static void addRecepta() {

        int id_Recepta, id_Xef = 0;
        String elaboracio, temps, nom, dificultat;

        escriu("Identificador de la recepta");
        // id automatic
        id_Recepta = catalogo.getReceptes().size() + 1;
        // a quin xef pertany
        mostrarXefs();
        id_Xef = llegeixInt();
        escriu("Elaboració:");
        elaboracio = llegeixString();
        escriu("Temps:");
        temps = llegeixString();
        escriu("Nom:");
        nom = llegeixString();
        escriu("Dificultat:");
        dificultat = llegeixString();

        Recepta recepta = new Recepta(id_Recepta, elaboracio, temps, nom, dificultat, id_Xef, id_Xef);
        addRecepToBD(recepta);

    }

    private static void addPlat() {
        
        int id_Recepta,id_Plat = 0;
        String nom, descripcio;
        
        mostrarReceptes();
        id_Recepta = llegeixInt();
        
        escriu("ID del plat automàtic.\n");
        id_Plat = catalogo.getPlat().size();
        
        escriu("Nom del plat:\n");
        nom = llegeixString();
        
        escriu("Descripcio del plat");
        descripcio = llegeixString();
        
        Plat plat = new Plat(id_Recepta, id_Plat, nom,descripcio);
        addPlatToBD(plat);
    
    }
    
    

    private static void addIngredient() {
        
        int id_Ingredient, id_Familia = 0;
        String refrigeracion, nom,familia;
        
        id_Ingredient = catalogo.getIngredients().size();
        
        mostrarFamilies();
        
        id_Familia = llegeixInt();
        
        escriu("Refrigeració?");
        refrigeracion = llegeixString();
        
        escriu("Nom de la familia:\n");
        familia = llegeixString();
        
        escriu("Nom ingredient:\n");
        nom = llegeixString();
        
        Ingredient ingredient = new Ingredient(id_Ingredient, refrigeracion, id_Familia, familia,nom);
        
        addIngredientToBD(ingredient);
        
        
    }

    private static void addTipusMenjar() {
        
        int id_Tipus = 0;
        String nom;
        
        id_Tipus = catalogo.getTipusMenjar().size();
        
        escriu("Introdueix el nom del tipus de menjar.\n");
        nom = llegeixString();
        //La relació entre plat i el tipus de menjar no esta definida
        Tipus_Menjar tM = new Tipus_Menjar(id_Tipus, null, nom);
        addTipusMenjar(tM);
        
        
        
    }

    private static void addXef() {
        int int_Estrelles, id_Xef = 0;
        String nom;
        
        escriu("Quantes estrelles té el xef:\n");
        int_Estrelles = llegeixInt();
        
        escriu("ID del xef automàtic\n");
        id_Xef = catalogo.getXef().size();
        
        escriu("Nom del xef\n");
        nom = llegeixString();
        
        Xef xef = new Xef(int_Estrelles, id_Xef, nom, catalogo);
        addXefToBD(xef);
    }

    

   

    

    

    
}
