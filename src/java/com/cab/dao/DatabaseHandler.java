package com.cab.dao;

import com.cab.model.Customer;
import com.cab.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CabSystemDB";
    private static final String USER = "sa"; // Replace with your SQL Server username
    private static final String PASSWORD = "12345"; // Replace with your SQL Server password

    // Method to add a customer to the database
    public void addCustomer(Customer customer) {
        String query = "INSERT INTO Customer (name, address, nic, phoneNumber) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getNic());
            preparedStatement.setString(4, customer.getPhoneNumber());

            preparedStatement.executeUpdate();
            System.out.println("Customer added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a user from the database
    public User getUser(String username) {
        String query = "SELECT * FROM [User] WHERE username = ?";
        User user = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}