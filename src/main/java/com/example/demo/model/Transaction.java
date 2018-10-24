package com.example.demo.model;



public class Transaction {


    private Long receiver_id;
    private Long giver_id;
    private Double amount;
    private String form;
    private Long transaction_id;

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Long getGiver_id() {
        return giver_id;
    }

    public void setGiver_id(Long giver_id) {
        this.giver_id = giver_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double ammount) {
        this.amount = ammount;
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