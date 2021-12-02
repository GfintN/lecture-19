package by.it.academy.enterprise.dao.strategy.mapping;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.mapped.Vegetables;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class VegetablesDAOImpl implements DAO<Vegetables> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Vegetables save(Vegetables vegetables ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(vegetables);
            em.getTransaction().commit();
            logger.trace("VegetablesDAOImpl save success");
            return vegetables;
        } catch (HibernateException x){
            logger.error("VegetablesDAOImpl save error",x);
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
    public Vegetables delete(int id) {
        EntityManager em = null;
        Vegetables vegetables = new Vegetables();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            vegetables = em.find(Vegetables.class, vegetables.getId());
            em.remove(vegetables);
            em.getTransaction().commit();
            logger.trace("VegetablesDAOImpl delete success");
            return vegetables;
        } catch (HibernateException x){
            logger.error("VegetablesDAOImpl delete error",x);
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
    public Vegetables get(int id) {
        EntityManager em = null;
        Vegetables vegetables = new Vegetables();
        try {
            em = HibernateUtil.getEntityManager();
            vegetables = em.find(Vegetables.class, vegetables.getId());
            logger.trace("VegetablesDAOImpl get success");
            return vegetables;
        } catch (HibernateException x){
            logger.error("VegetablesDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Vegetables update(Vegetables vegetables ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            vegetables = em.find(Vegetables.class, vegetables.getId());
            em.merge(vegetables);
            em.getTransaction().commit();
            logger.trace("VegetablesDAOImpl update success");
            return vegetables;
        } catch (HibernateException x){
            logger.error("VegetablesDAOImpl update error",x);
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
