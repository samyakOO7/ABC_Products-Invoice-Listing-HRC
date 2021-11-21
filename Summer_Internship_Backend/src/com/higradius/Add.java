package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Add {

    public static int Execution(ExecutionResponse execution) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO mytable" +
            "  (name_customer, cust_number, invoice_id, total_open_amount, due_in_date, clear_date, Notes) VALUES " +
            " (?, ?, ?, ?, ?,'-',?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/data", "root", "Samyak123");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, execution.getCustname());
            preparedStatement.setString(2, execution.getCustnumber());
            preparedStatement.setString(3, execution.getInvoice());
            preparedStatement.setString(4, execution.getAmt());
            preparedStatement.setString(5, execution.getDuedate());
            preparedStatement.setString(6, execution.getNotes());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}