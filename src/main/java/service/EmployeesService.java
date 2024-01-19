package service;

import bin.Employees;
import dao.impl.EmployeesDAO;

public interface EmployeesService {
    public void createEmployees(Employees employees);
    public void getEmployeeId();

    public int getNumberOfEmployees();
}
