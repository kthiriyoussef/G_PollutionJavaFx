package com.example.pollutiondashboard.Services;
import java.util.List;
public interface sourceService<T> {
    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);
    int lastId();
    T findById(int id);
    List<T> findAll();
    List<T> findEm();
    int nbSource();
}
