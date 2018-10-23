package com.example.demo.db;
import com.example.demo.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTransactions extends connection {

    private Transaction getTransaction(Long id) {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM TRANSACTION";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            Transaction transaction = new Transaction();
            while (rs.next()) {

                transaction.setTransaction_id(rs.getLong("transaction_id"));
                transaction.setReceiver(rs.getString("receiver"));
                transaction.setGiver(rs.getString("giver"));
                transaction.setHow_much(rs.getLong("How_much"));
                transaction.setForm(rs.getString("Form"));
            }
            connection.close();
            return transaction;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    private Transaction getReceiver() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT receiver FROM TRANSACTION";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();


            Transaction transaction = new Transaction();
            while (rs.next()) {

                transaction.setReceiver(rs.getString("receiver"));

            }
            connection.close();
            return transaction;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    private Transaction getGiver() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT giver FROM TRANSACTION";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            Transaction transaction = new Transaction();
            while (rs.next()) {

                transaction.setGiver(rs.getString("giver"));

            }
            connection.close();
            return transaction;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    private Transaction receiverGiver() {

        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT receiver, giver FROM TRANSACTION";

        try {
            Connection connection = getConnection();
            preparedStatement = connection.prepareStatement(selectSQL);


            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            Transaction transaction = new Transaction();
            while (rs.next()) {

                transaction.setGiver(rs.getString("giver"));
                transaction.setReceiver(rs.getString("receiver"));

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
            preparedStatement.setString(2, transaction.getReceiver());
            preparedStatement.setString(3, transaction.getGiver());
            preparedStatement.setLong(4, transaction.getHow_much());
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

