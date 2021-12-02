package by.it.academy.enterprise.dao.strategy.one;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.one.Cats;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class CatsDAOImpl implements DAO<Cats> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Cats save(Cats cats) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(cats);
            em.getTransaction().commit();
            logger.trace("CatsDAOImpl save success");
            return cats;
        } catch (HibernateException x){
            logger.error("CatsDAOImpl save error",x);
            if (em != null) {
                em.getTransaction().rollback();
            }
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cats delete(int id) {
        EntityManager em = null;
        Cats cats = new Cats();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            cats = em.find(Cats.class, cats.getId());
            em.remove(cats);
            em.getTransaction().commit();
            logger.trace("CatsDAOImpl delete success");
            return cats;
        } catch (HibernateException x){
            logger.error("CatsDAOImpl delete error",x);
            if (em != null) {
                em.getTransaction().rollback();
            }
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cats get(int id) {
        EntityManager em = null;
        Cats cats = new Cats();
        try {
            em = HibernateUtil.getEntityManager();
            cats = em.find(Cats.class, cats.getId());
            logger.trace("CatsDAOImpl get success");
            return cats;
        } catch (HibernateException x){
            logger.error("CatsDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Cats update(Cats cats) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            cats = em.find(Cats.class, cats.getId());
            em.merge(cats);
            em.getTransaction().commit();
            logger.trace("CatsDAOImpl update success");
            return cats;
        } catch (HibernateException x){
            logger.error("CatsDAOImpl update error",x);
            if (em != null) {
                em.getTransaction().rollback();
            }
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
