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
public class OperacionsRecepta {

    private Session sesion;
    private Transaction tx;
 /**
  *Obte recepta que correspon a la id
  *
  * @param id_Recepta id a obtenir
  * @return recepta que correspon amb id
  */
    public Recepta getRecepta(int id_Recepta) throws HibernateException {
        Recepta recepta = null;
        try {
            connecta();
            recepta = (Recepta) sesion.get(Recepta.class, id_Recepta);
        } finally {
            sesion.close();
        }
        return recepta;
    }
 /**
  *Onte les recepta, fa la consulta a la bbdd
  *
  * @return listRecepta de la bbdd
  */
    public List<Recepta> getListRecepta() throws HibernateException {
        List<Recepta> listRecepta = null;
        try {
            connecta();
            listRecepta = sesion.createQuery("from Recepta").list();
        } finally {
            sesion.close();
        }
        return listRecepta;
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
  *Guarda la recepta a la bbdd
  * @param recepta que volem guardar
  * @return id de la recepta introduit
  */
    public int guardarRecepta(Recepta recepta) throws HibernateException {
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(recepta);
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
  *Actualitza la recepta a la bbdd
  * @param recepta que volem actualitzar
  * @return id de la recepta
  */
    public int actualitzaRecepta(Recepta recepta) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.update(recepta);
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
  * Borra recepta de la bbdd
  * @param recepta que volem actualitzar
  * @return id de recepta borrada
  */
    public int borrarRecepta(Recepta recepta) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.delete(recepta);
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
