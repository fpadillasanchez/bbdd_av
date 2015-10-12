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
 /**
  *Obte tipus menjar que correspon a la id
  *
  * @param id_TipusMenjar id a obtenir
  * @return tipusMenjar que correspon amb id
  */
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
 /**
  *Onte tipus Menjar, fa la consulta a la bbdd
  *
  * @return listTipus_Menjars de la bbdd
  */
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
 /**
  *Guarda el tipus Menjar a la bbdd
  * @param tipus_Menjar que volem guardar
  * @return id de el tipus Menjar introduit
  */
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
 /**
  *Actualitza el tipus Menjar a la bbdd
  * @param tipus_Menjar que volem actualitzar
  * @return id del tipus Menjar
  */
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
 /**
  * Borra tipus Menjar de la bbdd
  * @param tipus_Menjar que volem actualitzar
  * @return id de tipus Menjar borrat
  */
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
