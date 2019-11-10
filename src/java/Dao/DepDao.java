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
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DepDao {

    private static Session session;
    private static Transaction tx;
  
    public void add(Dept d) {
        Transaction transaction=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //save the student object
            session.save(d);
            
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

    public boolean update(Dept d) {
        Transaction transaction = null;
          try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            
            session.update(d);
            
            
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

    public List<Dept> findAll() {
        Transaction transaction=null;
        List<Dept> MaListe=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user object
            MaListe = session.createQuery("from Dept").list();
            
            //commit transaction
            transaction.commit();
            
            session.close();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        
        return MaListe;
    }
    
    
    public Dept findById(String id)
    {
        Transaction transaction = null;
        Dept dept = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user
             dept = (Dept)session.get(Dept.class, id);
            
            //commit transaction
            transaction.commit();
            session.close();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return dept;
    }

    /*public Dept findById(String code) {

    }*/

    public void delete(String id) {
       Transaction transaction = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //update employees
            EmpDao empDao= new EmpDao();
            List<Emp> empL;
            
            
            //delete departement
            Dept dept = (Dept)session.get(Dept.class, id);
            
            
            
            if(dept != null){
                //find Employees
                empL= empDao.findAllByDept(dept);
                Dept d = dept;
                for(Emp e:empL){
                    d.setDeptno("1");
                    

                    e.setDept(d);
                    if(empDao.Update(e)){
                        System.out.println("Employee: "+e.getEmpno()+" UPDATED");
                    }else{
                        System.out.println("Employee: "+e.getEmpno()+" CAN'T UPDATED");
                    }
                }
                session.delete(dept);
                System.out.println("Departement is deleted");
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