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
import com.ub.edu.bda.Model.Xef;
import com.ub.edu.bda.Vista.ConnectorHB;

/**
 *
 * @author oriol
 */
public class operacionsPlat {
    private Session sesion; 
    private Transaction tx;
    
    public Plat getPlat(int id_Plat) throws HibernateException { 
        Plat plat = null;  
        try{ 
            connecta(); 
            plat = (Plat) sesion.get(Plat.class, id_Plat); 
        } finally { 
            sesion.close(); 
        }  
        return plat; 
    }  
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
