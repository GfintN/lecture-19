package by.it.academy.enterprise.dao.strategy;

public interface DAO<T> {
    T save(T t);
    T delete(int id);
    T get(int id);
    T update(T t);
}
