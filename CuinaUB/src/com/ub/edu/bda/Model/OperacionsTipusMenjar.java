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
public class OperacionsTipusMenjar {

    private Session sesion;
    private Transaction tx;

    public Tipus_Menjar getTipusMenjar(int id_TipusMenjar) throws HibernateException {
        Tipus_Menjar tipusMenjar = null;
        try {
            connecta();
            tipusMenjar = (Tipus_Menjar) sesion.get(Tipus_Menjar.class, id_TipusMenjar);
        } finally {
            sesion.close();
        }
        return tipusMenjar;
    }

    public List<Tipus_Menjar> getListTipus_Menjars() throws HibernateException {
        List<Tipus_Menjar> listTipus_Menjars = null;
        try {
            connecta();
            listTipus_Menjars = sesion.createQuery("from Tipus_Menjar").list();
        } finally {
            sesion.close();
        }
        return listTipus_Menjars;
    }

    private void connecta() throws HibernateException {
        sesion = ConnectorHB.getSession();
        tx = sesion.beginTransaction();
    }

    private void excepcio(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrio un error al intentar accceder a los datos", he);
    }

    public int guardarTipusMenjar(Tipus_Menjar tipus_Menjar) throws HibernateException {
        int id = 0;
        try {
            connecta();
            id = (int) sesion.save(tipus_Menjar);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public int actualitzaTipusMenjar(Tipus_Menjar tipus_Menjar) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.update(tipus_Menjar);
            tx.commit();
        } catch (HibernateException he) {
            excepcio(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public int borrarTipusMenjar(Tipus_Menjar tipus_Menjar) throws HibernateException {
        int id = 0;
        try {
            connecta();
            sesion.delete(tipus_Menjar);
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
