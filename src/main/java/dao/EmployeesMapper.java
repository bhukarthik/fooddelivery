package dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import bin.Employees;

import java.io.IOException;


public interface EmployeesMapper {

    @Insert("insert into fooddelivery.employees(empid,first_name,last_name,phone_number,transportationmodes_vehicleid)values(?,?,?,?,?)")
    public void addEmployees(Employees employees);
    @Select("Select first_name from fooddelivery.employees where empid=?")
    public Employees getEmployeesById(int empId);
    @Select("SELECT COUNT(*) FROM fooddelivery.employees")
    public int getNumberOfEmployees();
}
