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
 * @author Oriol
 * @author Fernando
 */
public class OperacionsFamIngredient {

    private Session sesion;
    private Transaction tx;

    public Familia_Ingredients getFamIngredient(int id_FamIngredient) throws HibernateException {
        Familia_Ingredients famIngredient = null;
        try {
            connecta();
            famIngredient = (Familia_Ingredients) sesion.get(Familia_Ingredients.class, id_FamIngredient);
        } finally {
            sesion.close();
        }
        return famIngredient;
    }

    public List<Familia_Ingredients> getListFamIngredients() throws HibernateException {
        List<Familia_Ingredients> listFamIngredients = null;
        try {
            connecta();
            listFamIngredients = sesion.createQuery("from Familia_Ingredients").list();
        } finally {
            sesion.close();
        }
        return listFamIngredients;
    }

    private void connecta() throws HibernateException {
        sesion = ConnectorHB.getSession();
        tx = sesion.beginTransaction();
    }

    private void excepcio(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error al intentar accceder a los datos", he);
    }

    public int guardarFamIngredient(Familia_Ingredients famIngredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(famIngredient);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public int actualitzaFamIngredient(Familia_Ingredients famIngredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.update(famIngredient);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public int borrarFamIngredient(Familia_Ingredients famIngredient) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.delete(famIngredient);
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
