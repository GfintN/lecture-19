package by.it.academy.enterprise.dao.strategy.mapping;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.mapped.Fruits;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class FruitsDAOImpl implements DAO<Fruits> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Fruits save(Fruits fruits ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(fruits);
            em.getTransaction().commit();
            logger.trace("FruitsDAOImpl save success");
            return fruits;
        } catch (HibernateException x){
            if (em != null) {
                logger.error("FruitsDAOImpl save error",x);
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
    public Fruits delete(int id) {
        EntityManager em = null;
        Fruits fruits = new Fruits();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            fruits = em.find(Fruits.class, fruits.getId());
            em.remove(fruits);
            em.getTransaction().commit();
            logger.trace("FruitsDAOImpl delete success");
            return fruits;
        } catch (HibernateException x){
            logger.error("FruitsDAOImpl delete error",x);
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
    public Fruits get(int id) {
        EntityManager em = null;
        Fruits fruits = new Fruits();
        try {
            em = HibernateUtil.getEntityManager();
            fruits = em.find(Fruits.class, fruits.getId());
            logger.trace("FruitsDAOImpl get success");
            return fruits;
        } catch (HibernateException x){
            logger.error("FruitsDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Fruits update(Fruits fruits ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            fruits = em.find(Fruits.class, fruits.getId());
            em.merge(fruits);
            em.getTransaction().commit();
            logger.trace("FruitsDAOImpl update success");
            return fruits;
        } catch (HibernateException x){
            logger.error("FruitsDAOImpl update error",x);
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
