package service.impl;

import bin.Customers;
import bin.Employees;
import dao.impl.CustomersDAO;
import dao.impl.EmployeesDAO;
import service.CustomersService;

public class CustomersServiceImpl implements CustomersService {
    CustomersDAO customersDAO = new CustomersDAO();
    @Override
    public void createCustomers(Customers customers) {
        customersDAO.addCustomers(customers);
    }
    @Override
    public void getCustomerId(int id) {

    }
}
