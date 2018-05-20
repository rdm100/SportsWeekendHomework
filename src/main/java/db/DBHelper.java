package db;

import models.League;
import models.Player;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Session session;
    private static Transaction transaction;

    public static void saveOrUpdate(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();

        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T>  getAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static <T> T find(Class classType, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T)cr.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }




    public static  List<Player> getPlayersByTeam(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Player.class);
            cr.add(Restrictions.eq("team", team));
            results =  cr.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Team> getTeamsByLeague(League league) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> results = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Team.class);
            cr.add(Restrictions.eq("league", league));
            results =  cr.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Team> getOrderOfTeamByPoints(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> teams = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Team.class);
            cr.addOrder(Order.desc("points"));
            teams = cr.list();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teams;
    }

}
