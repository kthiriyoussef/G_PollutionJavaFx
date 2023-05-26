package com.example.pollutiondashboard.Services;

import com.example.pollutiondashboard.connexion.connexion;
import com.example.pollutiondashboard.entities.Emission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.List;

public class emissionServiceImpl implements emissionService<Emission> {


    @Override
    public boolean create(Emission o) {
        try {
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String sql = "INSERT INTO emission (Source, typeSource, Emission, idSource) VALUES (?, ?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getSource());
            stmt.setString(2, o.getTypeSource());
            stmt.setFloat(3, o.getEmission());
            stmt.setInt(4, o.getIdSource());
            // Execute the SQL statement
            int rowsAffected = stmt.executeUpdate();

            // Close the statement and connection
            stmt.close();


            System.out.println(rowsAffected + " row(s) affected.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Emission o) {
        return false;
    }

    @Override
    public boolean delete(Emission o) {
        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            String sql = "DELETE FROM emission WHERE idEmission = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, o.getIdEmission());
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public int lastId() {
        int id=0;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT MAX(idEmission) FROM emission");
            if (resultSet.next()) {
                int lastId = resultSet.getInt(1);
                // Use the lastId value as needed
                id= lastId;
            }
        } catch (SQLException e) {
            id=0;
            e.printStackTrace();
        }
        return  id;
    }

    @Override
    public Emission findById(int id) {
        return null;
    }

    @Override
    public List<Emission> findAll() {
        ObservableList<Emission> data = FXCollections.observableArrayList();
        try{
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String query = "SELECT * FROM emission";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmission=resultSet.getInt("idEmission");
                String source = resultSet.getString("Source");
                String TypeSource = resultSet.getString("typeSource");
                String emission = resultSet.getString("Emission");
                Emission E = new Emission(idEmission,source, TypeSource, Float.parseFloat(emission));
                data.add(E);
            }




        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

        return data;
}

    @Override
    public float maxEm() {
        Statement statement = null;
        ResultSet resultSet = null;
        float maxEm=0;
        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT max(Emission) FROM emission");
            if (resultSet.next()) {
                float max = resultSet.getFloat(1);
                // Use the lastId value as needed
                maxEm= max;
            }
        } catch (SQLException e) {
            maxEm=0;
            e.printStackTrace();
        }
        return  maxEm;
    }

    @Override
    public ObservableList<XYChart.Data<String, Number>> chart() {
        ObservableList<XYChart.Data<String, Number>> chartData = FXCollections.observableArrayList();
        try{
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String query = "SELECT Emission, source FROM emission";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Number emission = resultSet.getBigDecimal("emission");
                String source = resultSet.getString("source");
                chartData.add(new XYChart.Data<>(source, emission));
                    }
        }
     catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return chartData;
}}
