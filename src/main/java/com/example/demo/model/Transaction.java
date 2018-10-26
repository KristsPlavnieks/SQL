package com.example.demo.model;



public class Transaction {


    private Long receiverId;
    private Long giverId;
    private Double amount;
    private String form;
    private Long transaction_id;

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getGiverId() {
        return giverId;
    }

    public void setGiverId(Long giverId) {
        this.giverId = giverId;
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