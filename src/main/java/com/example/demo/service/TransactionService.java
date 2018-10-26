package com.example.demo.service;

import com.example.demo.db.dbTransactions;
import com.example.demo.model.Person;
import com.example.demo.model.Transaction;

import java.util.List;

public class TransactionService {

    private final dbTransactions dbTransactions;
    private final peopleService peopleService;

    public TransactionService(dbTransactions dbTransactions, peopleService peopleService) {
        this.dbTransactions = dbTransactions;
        this.peopleService = peopleService;
    }

    public String saveTransaction(Transaction transaction) {
        String isSaveSucsesful = dbTransactions.saveTransaction(transaction);

        Long[] personsToget = {transaction.getGiverId(), transaction.getReceiverId()};
        List<Person> involvedPersons = peopleService.getPersonsById(personsToget);



        if (transaction.getForm().equals("J")) {

        }

        if (result.equals("J")) {

            if (transaction.getForm().equals("repayment")) {
                personsGiver.setDebt(personGiver.getDebt() - transaction.getAmount());
                personReciver.setLent(personGiver.getLent() - transaction.getAmount());
            } else {
                personGiver.setLent(personGiver.getLent() + transaction.getAmount());
                personReciver.setDebt(personGiver.getDebt() + transaction.getAmount());
            }

        }
        return null;
    }

    public Boolean validateRepayment(Transaction transaction) {

    }

    public List<Transaction> getTransactions() {
        return dbTransactions.getTransactions();
    }

    public List<Transaction> getGiversTransactions(Long id) {
        return dbTransactions.getTransactionsWhereGiverById(id);
    }

    public List<Transaction> getReciversTransactions(Long id) {
        return dbTransactions.getTransactionsWhereReceiverById(id);
    }

    public List<Transaction> getReciverGiverTransactionsById(Long id) {
        return dbTransactions.getReceiverGiverTransactionsById(id);
    }
}
