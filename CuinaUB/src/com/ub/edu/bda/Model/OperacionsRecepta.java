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
    
    public Recepta getRecepta(int id_Recepta) throws HibernateException { 
        Recepta recepta = null;  
        try{ 
            connecta(); 
            recepta = (Recepta) sesion.get(Recepta.class, id_Recepta); 
        } finally { 
            sesion.close(); 
        }  
        return recepta; 
    }  
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

