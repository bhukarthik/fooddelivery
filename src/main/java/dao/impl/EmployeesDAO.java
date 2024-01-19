package dao.impl;

import bin.Employees;
import dao.EmployeesMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;
import util.DButil;
import util.MyBatisUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static util.MyBatisUtil.sesFact;


public class EmployeesDAO implements EmployeesMapper {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeesDAO.class);
    public static final String employeesSQL = "insert into fooddelivery.employees(empid,first_name,last_name,phone_number,transportationmodes_vehicleid)values(?,?,?,?,?)";
    public static final String empidSQL = "select * from employees where empid=?";

    public void addEmployees(Employees employees) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(employeesSQL)){
            preparedStatement.setInt(1, employees.getEmpId());
            preparedStatement.setString(2, employees.getFirstName());
            preparedStatement.setString(3, employees.getLastName());
            preparedStatement.setLong(4, employees.getPhoneNumber());
            preparedStatement.setString(5, employees.getTransportationmodesvehicleid());
            preparedStatement.executeUpdate();
            LOGGER.info("Row Inserted into DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
    }

    public Employees getEmployeesById(int employeeId) {
        Employees employees = new Employees();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(empidSQL)){
            preparedStatement.setInt(1, employeeId);
            try(ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    employees.setEmpId(rs.getInt("empid"));
                    employees.setFirstName(rs.getString("first_name"));
                    employees.setLastName(rs.getString("last_name"));
                    employees.setPhoneNumber(rs.getLong("phone_number"));
                }
                LOGGER.info("Employee Id " + employees.getEmpId());
                LOGGER.info("First Name " + employees.getFirstName());
                LOGGER.info("Last Name " + employees.getLastName());
                LOGGER.info("Phone Number " + employees.getPhoneNumber());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
        return employees;
    }
    public int getNumberOfEmployees() {
    // No JDBC Implimentation
        return 0;
    }
}
