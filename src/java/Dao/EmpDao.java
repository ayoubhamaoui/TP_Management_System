/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author ayoub
 */

import Entity.Dept;
import Entity.Emp;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpDao
        
{
    private static Session session;
    private static Transaction tx;
    
    public void Add(Emp emp)
    {
        Transaction transaction=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //save the student object
            session.save(emp);
            
            //commit transaction
            transaction.commit();
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        
    }
    
    public List<Emp> findAll()
    {
        Transaction transaction=null;
        List<Emp> MaListe=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user object
            MaListe = session.createQuery("from Emp").list();
            
            //commit transaction
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        
        return MaListe;
    }
    
    public Emp findById(String id)
    {
        Transaction transaction = null;
        Emp emp = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user
            emp = (Emp)session.get(Emp.class, id);
            
            //commit transaction
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return emp;
    }
    
    public List<Emp> findAllByDept(Dept D) {
         Transaction transaction=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //save the student object
            Query req = session.createQuery("select e from Emp e where e.dept.deptno = :dept_no");
            req.setParameter("dept_no", D.getDeptno());
                        
            //commit transaction
            transaction.commit();
            return req.list();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean Update(Emp emp)
    {
          Transaction transaction = null;
          try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            
            session.update(emp);
            
            
            //commit transaction
            transaction.commit();
            session.close();
            return true;
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
            
        } 
    }
    
    public void remove(String id)
    {
        Transaction transaction = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //delete user
            Emp emp = (Emp)session.get(Emp.class, id);
            if(emp != null){
                session.delete(emp);
                System.out.println("User is deleted");
            }
            
            //commit transaction
            transaction.commit();
            session.close();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
            
    }
}

