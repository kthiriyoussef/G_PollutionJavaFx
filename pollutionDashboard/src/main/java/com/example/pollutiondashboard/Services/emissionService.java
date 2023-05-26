package com.example.pollutiondashboard.Services;

import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.util.List;

public interface emissionService<T> {
    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);
    int lastId();
    T findById(int id);
    List<T> findAll();
    float maxEm();
    ObservableList<XYChart.Data<String, Number>> chart();

}
