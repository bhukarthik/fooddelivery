package dao;
import org.apache.ibatis.annotations.Select;
import bin.Employees;

import java.io.IOException;


public interface EmployeesMapper {

    public void addEmployees(Employees employees);
    public Employees getEmployeesById(int empId);
    @Select("SELECT COUNT(*) FROM fooddelivery.employees")
    public int getNumberOfEmployees();
}
