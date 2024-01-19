package dao.impl;

import bin.Customers;
import bin.Employees;
import dao.CustomersMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersDAO implements CustomersMapper {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CustomersDAO.class);
    private static final String customersSQL = "insert into fooddelivery.customers(cusid,first_name,last_name,address,city,state,zipcode,phone_number,email_id)values(?,?,?,?,?,?,?,?,?)";
    public static final String cusidSqL = "select * from customers where cusid=?";

    public void addCustomers(Customers customers) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(customersSQL)){
            preparedStatement.setInt(1, customers.getCusId());
            preparedStatement.setString(2, customers.getFirstName());
            preparedStatement.setString(3, customers.getLastName());
            preparedStatement.setString(4, customers.getAddress());
            preparedStatement.setString(5, customers.getCity());
            preparedStatement.setString(6, customers.getState());
            preparedStatement.setInt(7, customers.getZipCode());
            preparedStatement.setLong(8, customers.getPhone_number());
            preparedStatement.setString(9, customers.getEmailId());
            preparedStatement.executeUpdate();
            LOGGER.info("Row Inserted into DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
    }

    public Customers getCustomersByID(int customerId) {
        Customers customers = new Customers();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(cusidSqL)){
            preparedStatement.setInt(1, customerId);
            try(ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    customers.setCusId(rs.getInt("cusid"));
                    customers.setFirstName(rs.getString("first_name"));
                    customers.setFirstName(rs.getString("last_name"));
                    customers.setAddress(rs.getString("address"));
                    customers.setCity(rs.getString("city"));
                    customers.setState(rs.getString("state"));
                    customers.setZipCode(rs.getInt("zip_code"));
                    customers.setPhone_number(rs.getLong("phone_number"));
                    customers.setEmailId(rs.getString("email_id"));
                }
                LOGGER.info("Customer Id " + customers.getCusId());
                LOGGER.info("First Name " + customers.getFirstName());
                LOGGER.info("Last Name " + customers.getLastName());
                LOGGER.info("Address " + customers.getAddress());
                LOGGER.info("City " + customers.getCity());
                LOGGER.info("State " + customers.getCity());
                LOGGER.info("Zip Code " + customers.getZipCode());
                LOGGER.info("Phone Number " + customers.getPhone_number());
                LOGGER.info("Email Id " + customers.getEmailId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
        return customers;
    }
}
