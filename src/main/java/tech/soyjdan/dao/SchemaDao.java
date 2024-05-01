package tech.soyjdan.dao;

import tech.soyjdan.utils.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaDao {

    private static final Connection connection = MySqlConnection.getConnection();

    public static void createSchema(String name) {
        try (Statement statement = connection.createStatement()) {
            String query = "CREATE SCHEMA IF NOT EXISTS `" + name + "` DEFAULT CHARACTER SET UTF8;";

            statement.execute(query);
            System.out.println("Create scheme successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void dropSchema(String name) {
        try (Statement statement = connection.createStatement()) {
            String query = "DROP SCHEMA IF EXISTS `" + name + "`;";

            statement.execute(query);
            System.out.println("Drop scheme successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }
}
