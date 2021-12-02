package by.it.academy.enterprise.dao.strategy.one;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.one.Dogs;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class DogsDAOImpl implements DAO<Dogs> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Dogs save(Dogs dogs ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(dogs);
            em.getTransaction().commit();
            logger.trace("DogsDAOImpl save success");
            return dogs;
        } catch (HibernateException x){
            logger.error("DogsDAOImpl save error",x);
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
    public Dogs delete(int id) {
        EntityManager em = null;
        Dogs dogs = new Dogs();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            dogs = em.find(Dogs.class, dogs.getId());
            em.remove(dogs);
            em.getTransaction().commit();
            logger.trace("DogsDAOImpl delete success");
            return dogs;
        } catch (HibernateException x){
            logger.error("DogsDAOImpl delete error",x);
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
    public Dogs get(int id) {
        EntityManager em = null;
        Dogs dogs = new Dogs();
        try {
            em = HibernateUtil.getEntityManager();
            dogs = em.find(Dogs.class, dogs.getId());
            logger.trace("DogsDAOImpl get success");
            return dogs;
        } catch (HibernateException x){
            logger.error("DogsDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Dogs update(Dogs dogs ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            dogs = em.find(Dogs.class, dogs.getId());
            em.merge(dogs);
            em.getTransaction().commit();
            logger.trace("DogsDAOImpl update success");
            return dogs;
        } catch (HibernateException x){
            logger.error("DogsDAOImpl update error",x);
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
