package by.it.academy.enterprise.dao.strategy.three;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.three.Student;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class StudentDAOImpl implements DAO<Student> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Student save(Student student ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            logger.trace("StudentDAOImpl save success");
            return student;
        } catch (HibernateException x){
            logger.error("StudentDAOImpl save error",x);
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
    public Student delete(int id) {
        EntityManager em = null;
        Student student = new Student();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, student.getPersonId());
            em.remove(student);
            em.getTransaction().commit();
            logger.trace("StudentDAOImpl delete success");
            return student;
        } catch (HibernateException x){
            logger.error("StudentDAOImpl delete error",x);
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
    public Student get(int id) {
        EntityManager em = null;
        Student student = new Student();
        try {
            em = HibernateUtil.getEntityManager();
            student = em.find(Student.class, student.getPersonId());
            logger.trace("StudentDAOImpl get success");
            return student;
        } catch (HibernateException x){
            logger.error("StudentDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Student update(Student student ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, student.getPersonId());
            em.merge(student);
            em.getTransaction().commit();
            logger.trace("StudentDAOImpl update success");
            return student;
        } catch (HibernateException x){
            logger.error("StudentDAOImpl update error",x);
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
