package service.impl;

import bin.Employees;
import dao.impl.EmployeesDAO;
import service.EmployeesService;

import java.io.IOException;

public class EmployeesServiceImpl implements EmployeesService {

    EmployeesDAO employeesDAO = new EmployeesDAO();
    @Override
    public void createEmployees(Employees employees) {
        employeesDAO.addEmployees(employees);
    }
    @Override
    public void getEmployeeId(int id) {
        employeesDAO.getEmployeesById(id);

    }

    @Override
    public int getNumberOfEmployees() {
        EmployeesDAO employeesDAO1 = new EmployeesDAO();
        return employeesDAO1.getNumberOfEmployees();
    }
}
