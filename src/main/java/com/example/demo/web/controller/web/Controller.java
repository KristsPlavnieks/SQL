package com.example.demo.web.controller.web;

import com.example.demo.db.dbPerson;
import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mans")
public class Controller {
    private final nana nana;
    private final com.example.demo.db.dbPerson dbPerson;

    public Controller(nana nana, dbPerson dbPerson) {
        this.nana = nana;
        this.dbPerson = dbPerson;
    }

    @RequestMapping(value = "/greeting")
    public String greeting() {
        return nana.hey();
//        return new Person(1, "lalla", "Pu");
    }
    @RequestMapping(value = "/get-all")
    public List<Person> getPersons(){
        return dbPerson.getPerson();
    }

    @RequestMapping(value = "/save")
    public String savePerson(){
        Long x = new Long(1);
        Person person = new Person( x, "Jans", "adolgs");
        person.setDebt(x);
        person.setLent(x);

        return dbPerson.savePerson(person);
    }
    @RequestMapping(value = "/update")
    public String updatePerson(){
        Long x = new Long(1);
        Person person = new Person( x, "Krists", "adolgs");
        person.setDebt(x);
        person.setLent(x);

        return dbPerson.updatePerson(person);
    }
    @RequestMapping(value = "/delete")
    public String deletePersonById(){
        Long x = new Long(1);

        return dbPerson.deletePersonByID(x);
    }
}