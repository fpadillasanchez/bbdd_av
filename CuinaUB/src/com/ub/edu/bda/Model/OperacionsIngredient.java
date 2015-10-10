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
 * @author oriol
 */
public class OperacionsIngredient {

    private Session sesion;
    private Transaction tx;

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
