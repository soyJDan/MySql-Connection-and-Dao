package tech.soyjdan;

import tech.soyjdan.dao.PersonDao;
import tech.soyjdan.dao.SchemaDao;
import tech.soyjdan.models.Person;
import tech.soyjdan.utils.MySqlConnection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        SchemaDao.createSchema("waw");
        PersonDao.createTable("person");

        Person person1 = new Person("Juan", "Ojados", 39);
        Person person2 = new Person("Valeria", "Bedoya", 18);

        PersonDao.insertPerson(person1);
        PersonDao.insertPerson(person2);

        PersonDao.selectAllPerson();

        for (Person person : PersonDao.getPersonList()) {
            System.out.println(person);
        }
    }
}