package com.solvd.fooddelivery;

import bin.Employees;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.EmployeesServiceImpl;

public class EmployeesTest {
    EmployeesServiceImpl employeesService = new EmployeesServiceImpl();
    Employees employees = new Employees();

    @DataProvider(name="empid-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"103"}};
    }
    @Test(dataProvider = "empid-provider")
    public void testFindEmployeeById(String data){
        System.out.println("Data"+data);
        employeesService.getEmployeeIdTest(Integer.parseInt(data));
        Assert.assertEquals(data,"103");
    }
}
