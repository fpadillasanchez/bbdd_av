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
public class OperacionsPlat {

    private Session sesion;
    private Transaction tx;
 /**
  *Obte plat que correspon a la id
  *
  * @param id_Plat id a obtenir
  * @return plat que correspon amb id
  */
    public Plat getPlat(int id_Plat) throws HibernateException {
        Plat plat = null;
        try {
            connecta();
            plat = (Plat) sesion.get(Plat.class, id_Plat);
        } finally {
            sesion.close();
        }
        return plat;
    }
 /**
  *Obte el plat, fa la consulta a la bbdd
  *
  * @return listPlat de la bbdd
  */
    public List<Plat> getListPlat() throws HibernateException {
        List<Plat> listPlat = null;
        try {
            connecta();
            listPlat = sesion.createQuery("from Plat").list();
        } finally {
            sesion.close();
        }
        return listPlat;
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
  *Guarda el plat a la bbdd
  * @param plat que volem guardar
  * @return id del plat introduit
  */
    public int guardarPlat(Plat plat) throws HibernateException {
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(plat);
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
  *Actualitza el plat a la bbdd
  * @param plat que volem actualitzar
  * @return id de l'plat
  */
    public int actualitzaPlat(Plat plat) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.update(plat);
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
  * Borra plats de la bbdd
  * @param plat que volem actualitzar
  * @return id del plat borrat
  */
    public int borrarPlat(Plat plat) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.delete(plat);
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
