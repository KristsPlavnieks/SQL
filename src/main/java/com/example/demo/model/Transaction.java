package com.example.demo.model;



public class Transaction {

    private String receiver;
    private String giver;
    private Long how_much;
    private String form;
    private Long transaction_id;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getGiver() {
        return giver;
    }

    public void setGiver(String giver) {
        this.giver = giver;
    }

    public Long getHow_much() {
        return how_much;
    }

    public void setHow_much(Long how_much) {
        this.how_much = how_much;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }



}