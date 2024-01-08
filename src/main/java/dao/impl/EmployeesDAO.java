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
import util.DButil;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class EmployeesDAO implements EmployeesMapper {
    private final Connection connection;
    private static SqlSessionFactory sesFact = null;
    private static SqlSessionFactory factory = null;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeesDAO.class);

    public EmployeesDAO() {
        connection = DButil.getConnection();
    }

    public void addEmployees(Employees employees) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fooddelivery.employees(empid,first_name,last_name,phone_number)values(?,?,?,?)");
            preparedStatement.setInt(1, employees.getEmpId());
            preparedStatement.setString(2, employees.getFirstName());
            preparedStatement.setString(3, employees.getLastName());
            preparedStatement.setLong(4, employees.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Employees getEmployeesById(int employeeId) {
        Employees employees = new Employees();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where empid=?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employees.setEmpId(rs.getInt("empid"));
                employees.setFirstName(rs.getString("first_name"));
                employees.setLastName(rs.getString("last_name"));
                employees.setPhoneNumber(rs.getLong("phone_number"));
            }
            LOGGER.info("Employee Id "+employees.getEmpId());
            LOGGER.info("First Name "+employees.getFirstName());
            LOGGER.info("Last Name "+employees.getLastName());
            LOGGER.info("Phone Number "+employees.getPhoneNumber());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public int getNumberOfEmployees() {
        String resource = "src/main/resources/mybatis-config.xml";
        int numberOfEmployees=0;
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
            Properties prop = new Properties();
            prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
            prop.setProperty("url", "jdbc:mysql://localhost:3306/fooddelivery");
            prop.setProperty("user", "root");
            prop.setProperty("password", "JAutomation@123");
            PooledDataSource ds = new PooledDataSource();
            ds.setDriver(prop.getProperty("driver"));
            ds.setUrl(prop.getProperty("url"));
            ds.setUsername(prop.getProperty("user"));
            ds.setPassword(prop.getProperty("password"));
            TransactionFactory trFact = new JdbcTransactionFactory();
            Environment environment = new Environment("development", trFact,ds);
            Configuration config = new Configuration(environment);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(config);
            config.addMapper(EmployeesMapper.class);
            sesFact = new SqlSessionFactoryBuilder().build(config);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (SqlSession session = sesFact.openSession()){
            numberOfEmployees = session.selectOne("getNumberOfEmployees");
            LOGGER.info("Total Count "+numberOfEmployees);
        }
        return numberOfEmployees;
    }
}
