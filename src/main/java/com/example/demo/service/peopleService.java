package com.example.demo.service;

import com.example.demo.db.dbPerson;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peopleService {

    private final dbPerson dbPerson;

    peopleService(dbPerson dbPerson) {
        this.dbPerson = dbPerson;
    }

    public List<Person> getPersons() {
        return dbPerson.getPersons();
    }

    public List<Person> getPersonsById(Long[] id) {
        return dbPerson.getPersonsById(id);
    }

    public Person getPersonById(Long id) {
        Long[] ids = {id};
        return (Person) dbPerson.getPersonsById(ids);

    }

    public String deletePersonByID(Long id) {
        return dbPerson.deletePersonByID(id);
    }

    public String updatePerson(Person person) {
        String status = dbPerson.updatePerson(person);
        return status;
    }

    public String updatePersonLent() {
        return null;
    }

    public String updatePersonDebt() {
        return null;
    }
}
