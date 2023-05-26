package com.example.pollutiondashboard.Services;

import com.example.pollutiondashboard.connexion.connexion;
import com.example.pollutiondashboard.entities.Source;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class sourceServiceImpl implements sourceService <Source> {
    connexion con=new connexion();
    @Override
    public boolean create(Source o) {
        try {
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String sql = "INSERT INTO sourceemission (sourceEmission, typeSource, responsable, limiteReglementaire, Activité) VALUES (?, ?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getSourceEmission());
            stmt.setString(2, o.getTypeSource());
            stmt.setString(3, o.getResponsable());
            stmt.setString(4, o.getLimiteReglementaire());
            stmt.setString(5, o.getActivite());
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
    public boolean update(Source o) {

        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            String sql = "UPDATE sourceemission SET sourceEmission =?, typeSource=?, responsable=?, limiteReglementaire=?, Activité=? where idSource=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, o.getSourceEmission());
            stmt.setString(2, o.getTypeSource());
            stmt.setString(3, o.getResponsable());
            stmt.setString(4, o.getLimiteReglementaire());
            stmt.setString(5, o.getActivite());
            stmt.setInt(6, o.getIdSource());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Return true if at least one row was updated

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean delete(Source s) {
        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            String sql = "DELETE FROM sourceemission WHERE idSource = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getIdSource());
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
            resultSet = statement.executeQuery("SELECT MAX(idSource) FROM sourceemission");
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
    public Source findById(int id) {
        return null;
    }

    @Override
    public ObservableList<Source> findAll() {
        ObservableList<Source> data = FXCollections.observableArrayList();
        try{
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String query = "SELECT * FROM sourceemission";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idSource=resultSet.getInt("idSource");
                String sourceEmission = resultSet.getString("sourceEmission");
                String TypeSource = resultSet.getString("TypeSource");
                String responsable=resultSet.getString("responsable");
                String limiteReglementaire = resultSet.getString("limiteReglementaire");
                String activitee = resultSet.getString("Activité");
                Source S = new Source(idSource,sourceEmission, TypeSource, responsable,limiteReglementaire,activitee);
                data.add(S);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public List<Source> findEm() {
        ObservableList<Source> data = FXCollections.observableArrayList();
        try{
            connexion cnx=new connexion();
            Connection conn=cnx.getCn();
            String query = "SELECT * FROM sourceemission";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idSource=resultSet.getInt("idSource");
                String sourceEmission = resultSet.getString("sourceEmission");
                String TypeSource = resultSet.getString("TypeSource");
                String responsable=resultSet.getString("responsable");
                String limiteReglementaire = resultSet.getString("limiteReglementaire");
                String activitee = resultSet.getString("Activité");
                Source S = new Source(idSource,sourceEmission, TypeSource, responsable,limiteReglementaire,activitee);
                data.add(S);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;

    }

    @Override
    public int nbSource() {
        Statement statement = null;
        ResultSet resultSet = null;
        int nbs=0;
        try {
            connexion cnx = new connexion();
            Connection conn = cnx.getCn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT count(idSource) FROM sourceemission");
            if (resultSet.next()) {
                int nbsou = resultSet.getInt(1);
                // Use the lastId value as needed
                nbs= nbsou;
            }
        } catch (SQLException e) {
            nbs=0;
            e.printStackTrace();
        }
        return  nbs;
    }
}
