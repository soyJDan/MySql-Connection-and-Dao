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
        Person person3 = new Person("John", "Doe", 78);

        PersonDao.insertPerson(person1);
        PersonDao.insertPerson(person2);
        PersonDao.insertPerson(person3);

        PersonDao.selectAllPerson();

        for (Person person : PersonDao.getPersonList()) {
            System.out.println(person);
        }

        PersonDao.deletePerson(1);
        PersonDao.deletePerson(2);

        Person person4 = new Person("Luis", "Izalde", 24);
        PersonDao.updatePerson(person4, 5);

        PersonDao.selectPerson(6);
        System.out.println(PersonDao.getPerson());
    }
}