package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/MasterAnnonce";
    private static final String USER = "root";
    private static final String PASSWORD = "toto";

    private static Connection connect;

    /**
     * Constructeur privé pour empêcher l'instanciation externe
     */
    private ConnectionDB() throws ClassNotFoundException {
        try {
            // Charger le driver MySQL (optionnel avec JDBC 4+, mais bien de l'expliciter)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retourne l'instance unique de connexion
     */
    public static Connection getInstance() throws ClassNotFoundException {
        if (connect == null) {
            new ConnectionDB();
        }
        return connect;
    }
}
