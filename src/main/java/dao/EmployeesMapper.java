package dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import bin.Employees;

import java.io.IOException;


public interface EmployeesMapper {

    @Insert("insert into fooddelivery.employees(empid,first_name,last_name,phone_number,transportationmodes_vehicleid)values(#{empId},#{firstName},#{lastName},#{phoneNumber},#{transportationmodesvehicleid})")
    public void addEmployees(Employees employees);
    @Results({
            @Result(property = "empId", column = "empid"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "transportationmodesvehicleid", column = "transportationmodes_vehicleid")
    })
    @Select("Select * from fooddelivery.employees where empid = #{empId}")
    public Employees getEmployeesById(int empId);
    @Select("SELECT COUNT(*) FROM fooddelivery.employees")
    public int getNumberOfEmployees();
}
