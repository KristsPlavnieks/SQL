package com.example.demo.model;

public class Person {
    private Long id;
    private String name;
    private String surname;
    private Long debt;
    private Long lent;

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public Long getLent() {
        return lent;
    }

    public void setLent(Long lent) {
        this.lent = lent;
    }



    public Person(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
