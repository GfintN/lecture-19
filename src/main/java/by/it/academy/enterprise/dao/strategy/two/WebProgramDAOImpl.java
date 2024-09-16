package by.it.academy.enterprise.dao.strategy.two;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.two.WebProgram;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class WebProgramDAOImpl implements DAO<WebProgram> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public WebProgram save(WebProgram webProgram ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(webProgram);
            em.getTransaction().commit();
            logger.trace("WebProgramDAOImpl save success");
            return webProgram;
        } catch (HibernateException x){
            logger.error("WebProgramDAOImpl save error",x);
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
    public WebProgram delete(int id) {
        EntityManager em = null;
        WebProgram webProgram = new WebProgram();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            webProgram = em.find(WebProgram.class, webProgram.getId());
            em.remove(webProgram);
            em.getTransaction().commit();
            logger.trace("WebProgramDAOImpl delete success");
            return webProgram;
        } catch (HibernateException x){
            logger.error("WebProgramDAOImpl delete error",x);
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
    public WebProgram get(int id) {
        EntityManager em = null;
        WebProgram webProgram = new WebProgram();
        try {
            em = HibernateUtil.getEntityManager();
            webProgram = em.find(WebProgram.class, webProgram.getId());
            logger.trace("WebProgramDAOImpl get success");
            return webProgram;
        } catch (HibernateException x){
            logger.error("WebProgramDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public WebProgram update(WebProgram webProgram ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            webProgram = em.find(WebProgram.class, webProgram.getId());
            em.merge(webProgram);
            em.getTransaction().commit();
            logger.trace("WebProgramDAOImpl update success");
            return webProgram;
        } catch (HibernateException x){
            logger.error("WebProgramDAOImpl update error",x);
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
