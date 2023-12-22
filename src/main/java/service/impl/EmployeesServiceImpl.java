package service.impl;

import bin.Employees;
import dao.impl.EmployeesDAO;
import service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {

    EmployeesDAO employeesDAO = new EmployeesDAO();
    @Override
    public void createEmployees(Employees employees) {
        employeesDAO.addEmployees(employees);
    }
    @Override
    public void getEmployeeId(int id) {

    }
}
