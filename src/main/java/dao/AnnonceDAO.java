package dao;

import models.Annonce;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {

    public AnnonceDAO() throws SQLException, ClassNotFoundException {
        super(ConnectionDB.getInstance());
    }

    @Override
    public boolean create(Annonce obj) {
        String sql = "INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, obj.getTitle());
            ps.setString(2, obj.getDescription());
            ps.setString(3, obj.getAdress());
            ps.setString(4, obj.getMail());
            ps.setTimestamp(5, obj.getDate());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Annonce obj) {
        String sql = "UPDATE annonce SET title = ?, description = ?, adress = ?, mail = ?, date = ? WHERE id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, obj.getTitle());
            ps.setString(2, obj.getDescription());
            ps.setString(3, obj.getAdress());
            ps.setString(4, obj.getMail());
            ps.setTimestamp(5, obj.getDate());
            ps.setInt(6, obj.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Annonce obj) {
        String sql = "DELETE FROM annonce WHERE id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Annonce find(int id) {
        String sql = "SELECT * FROM annonce WHERE id = ?";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Annonce(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("adress"),
                            rs.getString("mail"),
                            rs.getTimestamp("date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Annonce> list() {
        ArrayList<Annonce> annonces = new ArrayList<>();
        String sql = "SELECT * FROM annonce";
        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Annonce annonce = new Annonce(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("adress"),
                        rs.getString("mail"),
                        rs.getTimestamp("date")
                );
                annonces.add(annonce);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonces;
    }
}
