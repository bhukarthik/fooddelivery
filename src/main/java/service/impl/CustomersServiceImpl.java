package service.impl;

import bin.Customers;
import bin.Employees;
import dao.impl.CustomersDAO;
import dao.impl.EmployeesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import service.CustomersService;

import java.util.Scanner;

public class CustomersServiceImpl implements CustomersService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(CustomersServiceImpl.class);
    CustomersDAO customersDAO = new CustomersDAO();
    @Override
    public void createCustomers() {
        Scanner myObj = new Scanner(System.in);
        LOGGER.info("Enter the Customer Id : ");
        int custId = myObj.nextInt();
        LOGGER.info("Enter the Customer First Name :");
        String firstName = myObj.nextLine();
        LOGGER.info("Enter the Customer Last Name :");
        String lastName = myObj.nextLine();
        LOGGER.info("Enter the Address");
        String address = myObj.nextLine();
        LOGGER.info("Enter the City");
        String city = myObj.nextLine();
        LOGGER.info("Enter the State");
        String state = myObj.nextLine();
        LOGGER.info("Enter the Zip Code");
        int zipCode = myObj.nextInt();
        LOGGER.info("Enter the phone Number");
        long phoneNumber = myObj.nextLong();
        LOGGER.info("Enter the Email");
        String email = myObj.nextLine();
        Customers customers = new Customers(custId,firstName,lastName,address,city,state,zipCode,phoneNumber,email);
        customersDAO.addCustomers(customers);
    }
    @Override
    public void getCustomerId() {
        Scanner myObj1 = new Scanner(System.in);
        LOGGER.info("Enter the Customer ID");
        int id = myObj1.nextInt();
        customersDAO.getCustomersByID(id);

    }
}
