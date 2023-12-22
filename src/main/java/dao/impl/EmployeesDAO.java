package dao.impl;

import bin.Employees;
import dao.EmployeesMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeesDAO implements EmployeesMapper {
    private Connection connection;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeesDAO.class);

    public EmployeesDAO(){
        connection = DButil.getConnection();
    }
    public void addEmployees(Employees employees){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fooddelivery.employees(empid,first_name,last_name,phone_number)values(?,?,?,?)");
            preparedStatement.setInt(1,employees.getEmpId());
            preparedStatement.setString(2,employees.getFirstName());
            preparedStatement.setString(3,employees.getLastName());
            preparedStatement.setLong(4,employees.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Employees getEmployeesById(int employeeId){
        Employees employees = new Employees();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where empid=?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                employees.setEmpId(rs.getInt("empid"));
                employees.setFirstName(rs.getString("first_name"));
                employees.setFirstName(rs.getString("last_name"));
                employees.setPhoneNumber(rs.getLong("phone_number"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  employees;
    }
}
