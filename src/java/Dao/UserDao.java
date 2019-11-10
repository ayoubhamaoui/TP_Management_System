/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utils.HibernateUtil;
import Entity.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ayoub
 */
public class UserDao {
    private static Session session;
    private static Transaction tx;
    
    public void saveUser(User user){
        Transaction transaction=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //save the student object
            session.save(user);
            
            //commit transaction
            transaction.commit();
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    
    public List<User> getAllUser(){
        Transaction transaction=null;
        List<User> MaListe=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user object
            MaListe = session.createQuery("from User").list();
            
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
    
    public void deleteUser(int id){
        Transaction transaction = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //delete user
            User user = (User)session.get(User.class, id);
            if(user != null){
                session.delete(user);
                System.out.println("User is deleted");
            }
            
            //commit transaction
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    
     public User getLogin(String login, String password) {
         
         try{
             session = HibernateUtil.getSessionFactory().openSession();
             
             // 'name_user' et 'password_user' sont les noms des attributs de ton objet
            Criteria crit = session.createCriteria(User.class, "user")
                .add( Restrictions.eq("user.login", login) )
                .add( Restrictions.eq("user.password", password) );
            return (User) crit.uniqueResult();
             
         }catch(HibernateException ex){
            ex.printStackTrace();
            return null;
        }
   }
    
    public User getUser(int id){
        Transaction transaction = null;
        User user = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            //start transaction
            transaction = session.beginTransaction();
            
            //get user
            user = (User)session.get(User.class, id);
            
            //commit transaction
            transaction.commit();
            
        }catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return user;
    }
    
    
}

