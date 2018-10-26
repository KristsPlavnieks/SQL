package com.example.demo.db;


import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class dbPerson extends connection {

    public List<Person> getPersons() {
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM PERSON";
        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            List<Person> persons = new ArrayList<>();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("person_id"));
                person.setName(rs.getString("NAME"));
                person.setSurname(rs.getString("SURNAME"));
                person.setDebt(rs.getDouble("DEBT"));
                person.setLent(rs.getDouble("LENT"));

                persons.add(person);
            }
            connection.close();
            return persons;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Person> getPersonsById(Long[] id) {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM PERSON WHERE PERSON_ID = ?";

        try {
            Connection connection = getConnection();
            List<Person> persons = new ArrayList<>();

            for (int i = 0; i < id.length; i++) {
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setLong(1, id[i]);
                ResultSet rs = preparedStatement.executeQuery();

                Person person = new Person();
                while (rs.next()) {

                    person.setId(rs.getLong("person_id"));
                    person.setName(rs.getString("NAME"));
                    person.setSurname(rs.getString("SURNAME"));
                    person.setDebt(rs.getDouble("DEBT"));
                    person.setLent(rs.getDouble("LENT"));
                }
                persons.add(person);
            }

            connection.close();
            return persons;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

//    public Person getPersonById(Long id) {
//
//        PreparedStatement preparedStatement = null;
//        String selectSQL = "SELECT * FROM PERSON WHERE PERSON_ID = ?";
//
//        try {
//            Connection connection = getConnection();
//            preparedStatement = connection.prepareStatement(selectSQL);
//            preparedStatement.setLong(1, id);
//
//            // execute select SQL stetement
//            ResultSet rs = preparedStatement.executeQuery();
//
//            Person person = new Person();
//            while (rs.next()) {
//
//                person.setId(rs.getLong("person_id"));
//                person.setName(rs.getString("NAME"));
//                person.setSurname(rs.getString("SURNAME"));
//                person.setDebt(rs.getDouble("DEBT"));
//                person.setLent(rs.getDouble("LENT"));
//            }
//            connection.close();
//            return person;
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }

    public String savePerson(Person person) {
        PreparedStatement preparedStatement = null;
        String selectSQL = "INSERT INTO person (person_id, NAME, SURNAME, DEBT, LENT) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());
            preparedStatement.setDouble(4, person.getDebt());
            preparedStatement.setDouble(5, person.getLent());

            // execute select SQL stetement
            preparedStatement.executeUpdate();
            connection.close();
            return "J";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public  String updatePerson(Person person){

        PreparedStatement preparedStatement = null;
        String selectSQL = "UPDATE PERSON SET NAME=?, SURNAME=?, WHERE PERSON_ID = ?";

        try{
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setLong(3, person.getId());

            preparedStatement.executeUpdate();
            connection.close();
            return "J";

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String updatePersonLent(Long id, Double ammount) {

        PreparedStatement preparedStatement = null;
        String selectSQL = "UPDATE PERSON SET Lent=?, WHERE PERSON_ID = ?";

        return null;
    }

    public String updatePersonDebt(Long id, Double ammount) {

        PreparedStatement preparedStatement = null;
        String selectSQL = "UPDATE PERSON SET Debt=?, WHERE PERSON_ID = ?";

        return null;
    }

    public String deletePersonByID(Long id) {

        PreparedStatement preparedStatement = null;
        String selectSQL = "DELETE FROM PERSON WHERE PERSON_ID = ?";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            connection.close();
            return "J";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
