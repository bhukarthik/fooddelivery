package dao;

import bin.Employees;

public interface EmployeesMapper {

    public void addEmployees(Employees employees);
    public Employees getEmployeesById(int empId);
}
