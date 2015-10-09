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
public class OperacionsRecepta {
    private Session sesion; 
    private Transaction tx;
    
    public Xef getXef(int id_Xef) throws HibernateException { 
        Xef xef = null;  
        try{ 
            connecta(); 
            xef = (Xef) sesion.get(Xef.class, id_Xef); 
        } finally { 
            sesion.close(); 
        }  
        return xef; 
    }  
    public List<Xef> getListXef() throws HibernateException { 
        List<Xef> listXef = null;  
        try { 
            connecta(); 
            listXef = sesion.createQuery("from Xef").list(); 
        } finally { 
            sesion.close(); 
        }  
        return listXef; 
    }      
    private void connecta() throws HibernateException { 
        sesion = ConnectorHB.getSession();
        tx = sesion.beginTransaction(); 
    }  
    private void excepcio(HibernateException he) throws HibernateException { 
        tx.rollback(); 
        throw new HibernateException("Ocurrio un error al intentar accceder a los datos", he); 
    } 
    public int guardarXef(Xef xef) throws HibernateException { 
        int id = 0;  
        try { 
            connecta(); 
            id = (int) sesion.save(xef); 
            tx.commit(); 
        } catch (HibernateException he) { 
            excepcio(he); 
            throw he; 
        } finally { 
            sesion.close(); 
        }  
        
        return id; 
    }
    public int actualitzaXef(Xef xef) throws HibernateException { 
        int id = 0;  
        try { 
            connecta(); 
            sesion.update(xef); 
            tx.commit(); 
        } catch (HibernateException he) { 
            excepcio(he); 
            throw he; 
        } finally { 
            sesion.close(); 
        }  
        
        return id; 
    }
    public int borrarXef(Xef xef) throws HibernateException { 
        int id = 0;  
        try { 
            connecta(); 
            sesion.delete(xef); 
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