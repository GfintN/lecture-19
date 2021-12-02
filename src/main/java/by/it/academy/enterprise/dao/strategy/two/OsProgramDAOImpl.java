package by.it.academy.enterprise.dao.strategy.two;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.two.OsProgram;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class OsProgramDAOImpl implements DAO<OsProgram> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public OsProgram save(OsProgram osProgram ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(osProgram);
            em.getTransaction().commit();
            logger.trace("OsProgramDAOImpl save success");
            return osProgram;
        } catch (HibernateException x){
            logger.error("OsProgramDAOImpl save error",x);
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
    public OsProgram delete(int id) {
        EntityManager em = null;
        OsProgram osProgram = new OsProgram();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            osProgram = em.find(OsProgram.class, osProgram.getId());
            em.remove(osProgram);
            em.getTransaction().commit();
            logger.trace("OsProgramDAOImpl delete success");
            return osProgram;
        } catch (HibernateException x){
            logger.error("OsProgramDAOImpl delete error",x);
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
    public OsProgram get(int id) {
        EntityManager em = null;
        OsProgram osProgram = new OsProgram();
        try {
            em = HibernateUtil.getEntityManager();
            osProgram = em.find(OsProgram.class, osProgram.getId());
            logger.trace("OsProgramDAOImpl get success");
            return osProgram;
        } catch (HibernateException x){
            logger.error("OsProgramDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public OsProgram update(OsProgram osProgram) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            osProgram = em.find(OsProgram.class, osProgram.getId());
            em.merge(osProgram);
            em.getTransaction().commit();
            logger.trace("OsProgramDAOImpl update success");
            return osProgram;
        } catch (HibernateException x){
            logger.error("OsProgramDAOImpl update error",x);
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
