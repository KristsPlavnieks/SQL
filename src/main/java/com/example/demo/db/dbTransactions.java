package com.example.demo.db;
import com.example.demo.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbTransactions extends connection {

    public List<Transaction> getTransaction() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM TRANSACTION";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);



            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            List<Transaction> transactions = new ArrayList<>();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransaction_id(rs.getLong("transaction_id"));
                transaction.setReceiver_id(rs.getLong("receiver_id"));
                transaction.setGiver_id(rs.getLong("giver_id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setForm(rs.getString("Form"));
                transactions.add(transaction);
            }
            connection.close();
            return transactions;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Transaction> getTransactionWhereReceiverId() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM TRANSACTION WHERE receiver_id=?";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);



            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();


            List<Transaction> transactions = new ArrayList<>();
            while (rs.next()) {

                Transaction transaction = new Transaction();
                transaction.setTransaction_id(rs.getLong("transaction_id"));
                transaction.setReceiver_id(rs.getLong("receiver_id"));
                transaction.setGiver_id(rs.getLong("giver_id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setForm(rs.getString("Form"));
                transactions.add(transaction);
            }
            connection.close();
            return transactions;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Transaction> getTransactionWhereGiverId() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM TRANSACTION WHERE giver_id=?";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            List<Transaction> transactions = new ArrayList<>();

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransaction_id(rs.getLong("transaction_id"));
                transaction.setReceiver_id(rs.getLong("receiver_id"));
                transaction.setGiver_id(rs.getLong("giver_id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setForm(rs.getString("Form"));
                transactions.add(transaction);

            }
            connection.close();
            return transactions;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Transaction receiverGiver() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM TRANSACTION WHERE receiver_id=?,giver_id=?";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            Transaction transaction = new Transaction();
            while (rs.next()) {

                transaction.setGiver_id(rs.getLong("giver_id"));
                transaction.setReceiver_id(rs.getLong("receiver_id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setForm(rs.getString("Form"));
                transaction.setTransaction_id(rs.getLong("transaction_id"));

            }
            connection.close();
            return transaction;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String saveTransaction(Transaction transaction) {
        PreparedStatement preparedStatement = null;
        String selectSQL = "INSERT INTO transaction (transaction_id, receiver, giver, How_much, Form) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, transaction.getTransaction_id());
            preparedStatement.setLong(2, transaction.getReceiver_id());
            preparedStatement.setLong(3, transaction.getGiver_id());
            preparedStatement.setDouble(4, transaction.getAmount());
            preparedStatement.setString(5, transaction.getForm());

            // execute select SQL stetement
            preparedStatement.executeUpdate();
            connection.close();
            return "J";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

