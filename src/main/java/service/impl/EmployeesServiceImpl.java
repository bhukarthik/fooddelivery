package service.impl;

import bin.Employees;
import dao.impl.EmployeesDAO;
import dao.mybatis.EmployeeMyBatisDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import service.EmployeesService;

import java.util.Scanner;

public class EmployeesServiceImpl implements EmployeesService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeesServiceImpl.class);
    EmployeesDAO employeesDAO = new EmployeesDAO();
    EmployeeMyBatisDAO employeeMyBatisDAOMyBatis = new EmployeeMyBatisDAO();
    @Override
    public void createEmployees(Employees employees) {
        Scanner myObj = new Scanner(System.in);
        LOGGER.info("Enter the Employee ID ");
        int empId = myObj.nextInt();
        employees.setEmpId(empId);
        LOGGER.info("Enter the Employee FirstName ");
        String firstName = myObj.nextLine();
        employees.setFirstName(firstName);
        LOGGER.info("Enter the Employee Last Name ");
        String lastName = myObj.nextLine();
        employees.setLastName(lastName);
        LOGGER.info("Enter the Employee Phone Number ");
        long phoneNumber = myObj.nextLong();
        employees.setPhoneNumber(phoneNumber);
        LOGGER.info("Enter the Transportation Mode (Car/Bike/CyCle) ");
        String transportMode = myObj.nextLine();
        employees.setTransportationmodesvehicleid(transportMode);
        Employees employeeObj= new Employees(empId,firstName,lastName,phoneNumber,transportMode);
        employeeMyBatisDAOMyBatis.addEmployees(employeeObj);
    }
    @Override
    public void getEmployeeId() {
        //employeesDAO.getEmployeesById(id);
        Scanner myObj1 = new Scanner(System.in);
        LOGGER.info("Enter the Employee Id");
        int id = myObj1.nextInt();
        employeeMyBatisDAOMyBatis.getEmployeesById(id);
    }

    @Override
    public int getNumberOfEmployees() {
        EmployeeMyBatisDAO employeeMyBatisDAO = new EmployeeMyBatisDAO();
        return employeeMyBatisDAO.getNumberOfEmployees();
    }
}
