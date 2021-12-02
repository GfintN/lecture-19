package by.it.academy.enterprise.dao.strategy.three;

import by.it.academy.enterprise.dao.strategy.DAO;
import by.it.academy.enterprise.pojo.strategy.three.Employee;
import by.it.academy.enterprise.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class EmployeeDAOImpl implements DAO<Employee> {
    private final Logger logger = LoggerFactory.getLogger("LOGS");

    @Override
    public Employee save(Employee employee ) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            logger.trace("EmployeeDAOImpl save success");
            return employee;
        } catch (HibernateException x){
            logger.error("EmployeeDAOImpl save error",x);
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
    public Employee delete(int id) {
        EntityManager em = null;
        Employee employee = new Employee();
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            employee = em.find(Employee.class, employee.getPersonId());
            em.remove(employee);
            em.getTransaction().commit();
            logger.trace("EmployeeDAOImpl delete success");
            return employee;
        } catch (HibernateException x){
            logger.error("EmployeeDAOImpl delete error",x);
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
    public Employee get(int id) {
        EntityManager em = null;
        Employee employee = new Employee();
        try {
            em = HibernateUtil.getEntityManager();
            employee = em.find(Employee.class, employee.getPersonId());
            logger.trace("EmployeeDAOImpl get success");
            return employee;
        } catch (HibernateException x){
            logger.error("EmployeeDAOImpl get error",x);
            return null;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Employee update(Employee employee) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            em.getTransaction().begin();
            employee = em.find(Employee.class, employee.getPersonId());
            em.merge(employee);
            em.getTransaction().commit();
            logger.trace("EmployeeDAOImpl update success");
            return employee;
        } catch (HibernateException x){
            logger.error("EmployeeDAOImpl update error",x);
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
