package tech.soyjdan.dao;

import tech.soyjdan.models.Person;
import tech.soyjdan.utils.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Data Access Object for Person entity.
 */
public class PersonDao {

    private static Connection connection;

    /**
     * Nombre de la tabla en la base datos
     */
    private static String name;

    private static final ArrayList<Person> personList = new ArrayList<>();
    private static final Person person = new Person();

    public static void createTable(String name) {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS `" + name + "` (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "FIRST_NAME VARCHAR(30) NOT NULL," +
                    "LAST_NAME VARCHAR(30) NOT NULL," +
                    "AGE INT(3) NOT NULL" +
                    ");";

            PersonDao.name = name;

            statement.execute(query);
            System.out.println("Create table successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void insertPerson(Person person) {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO " + name + "(FIRST_NAME, LAST_NAME, AGE) " +
                    "VALUES (" +
                    "'" + person.getFirstName() + "', " +
                    "'" + person.getLastName() + "', " +
                    person.getAge() +
                    ");";

            statement.execute(query);
            System.out.println("Insert data successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void deletePerson(long id) {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "DELETE FROM `" + name + "` WHERE ID = " + id + ";";

            statement.execute(query);
            System.out.println("Delete data successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void updatePerson(Person person, long id) {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "UPDATE " + name + " SET " +
                    "FIRST_NAME = '" + person.getFirstName() + "', " +
                    "LAST_NAME = '" + person.getLastName() + "', " +
                    "AGE = " + person.getAge() + " " +
                    "WHERE ID = " + id + ";";

            statement.execute(query);
            System.out.println("Update data successful");

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void selectAllPerson() {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM " + name + ";";

            statement.execute(query);

            System.out.println("Select all data successful");

            while (statement.getResultSet().next()) {
                Person personStm = new Person();

                personStm.setId(statement.getResultSet().getLong("ID"));
                personStm.setFirstName(statement.getResultSet().getString("FIRST_NAME"));
                personStm.setLastName(statement.getResultSet().getString("LAST_NAME"));
                personStm.setAge(statement.getResultSet().getInt("AGE"));

                personList.add(personStm);
            }

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static void selectPerson(long id) {
        try {
            connection = MySqlConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM " + name + " WHERE ID = " + id + ";";

            statement.execute(query);
            System.out.println("Select data successful");

            while (statement.getResultSet().next()) {
                person.setId(statement.getResultSet().getLong("ID"));
                person.setFirstName(statement.getResultSet().getString("FIRST_NAME"));
                person.setLastName(statement.getResultSet().getString("LAST_NAME"));
                person.setAge(statement.getResultSet().getInt("AGE"));
            }

            MySqlConnection.closeConnection(connection);
            System.out.println("Close connection successful");
        } catch (SQLException e) {
            System.err.println("Create statement failed");
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<Person> getPersonList() {
        return personList;
    }

    public static Person getPerson() {
        return person;
    }
}
