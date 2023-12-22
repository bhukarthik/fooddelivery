package dao.impl;

import bin.Customers;
import bin.Employees;
import dao.CustomersMapper;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersDAO implements CustomersMapper {
private Connection connection;

    public CustomersDAO(){
        connection = DButil.getConnection();
    }
    public void addCustomers(Customers customers){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fooddelivery.customers(cusid,first_name,last_name,address,city,state,zipcode,phone_number,email_id)values(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,customers.getCusId());
            preparedStatement.setString(2,customers.getFirstName());
            preparedStatement.setString(3,customers.getLastName());
            preparedStatement.setString(4,customers.getAddress());
            preparedStatement.setString(5,customers.getCity());
            preparedStatement.setString(6,customers.getState());
            preparedStatement.setInt(7,customers.getZipCode());
            preparedStatement.setLong(8,customers.getPhone_number());
            preparedStatement.setString(9,customers.getEmailId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Customers getCustomersByID(int customerId){
        Customers customers = new Customers();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customers where cusid=?");
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  customers;
    }
}
