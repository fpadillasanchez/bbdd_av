/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.edu.bda.Model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ub.edu.bda.Vista.ConnectorHB;

/**
 *
 * @author Fernando
 * @author Oriol
 */
public class OperacionsIngredient {

    private Session sesion;
    private Transaction tx;
 /**
  *Obte lingredients que correspon a la id
  *
  * @param id_Ingredient id a obtenir
  * @return Ingredient que correspon amb id
  */
    public Ingredient getIngredient(int id_Ingredient) throws HibernateException {
        Ingredient ingredient = null;
        try {
            connecta();
            ingredient = (Ingredient) sesion.get(Ingredient.class, id_Ingredient);
        } finally {
            sesion.close();
        }
        return ingredient;
    }
 /**
  *Onte l'ingredients, fa la consulta a la bbdd
  *
  * @return listIngredients de la bbdd
  */
    public List<Ingredient> getListIngredients() throws HibernateException {
        List<Ingredient> listIngredients = null;
        try {
            connecta();
            listIngredients = sesion.createQuery("from Ingredient").list();
        } finally {
            sesion.close();
        }
        return listIngredients;
    }

    private void connecta() throws HibernateException {
        sesion = ConnectorHB.getSession();
        tx = sesion.beginTransaction();
    }

    private void excepcio(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error al intentar accceder a los datos", he);
    }
 /**
  *Guarda l'ingredients a la bbdd
  * @param ingredient que volem guardar
  * @return id de l'ingredient introduit
  */
    public int guardarIngredient(Ingredient ingredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(ingredient);
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
  *Actualitza l'ingredient a la bbdd
  * @param ingredient que volem actualitzar
  * @return id de l'ingredient
  */
    public int actualitzaIngredient(Ingredient ingredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.update(ingredient);
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
  * Borra ingredients de la bbdd
  * @param ingredient que volem actualitzar
  * @return id de lingredient borrat
  */
    public int borrarIngredient(Ingredient ingredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.delete(ingredient);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

}
