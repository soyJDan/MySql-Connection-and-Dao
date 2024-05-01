package tech.soyjdan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para conectar a la base de datos
 */
public class MySqlConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE = "db";

    /**
     * Método que crea una conexión a la base de datos
     * @return conexión a la base de datos
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found");
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection failed");
            System.err.println(e.getMessage());
        }

        return null;
    }

    /**
     * Cierra una conexión abierta
     * @param connection conexión a cerrar
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed close connection");
            System.err.println(e.getMessage());
        }
    }
}
