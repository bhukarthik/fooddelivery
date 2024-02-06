package com.solvd.fooddelivery;

import bin.Employees;
import dao.impl.EmployeesDAO;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;

public class ValidEmployeeNameTest {
    EmployeesDAO employeesDAO = new EmployeesDAO();
    Employees employees = new Employees();

    @DataProvider(name = "ValidFirstName-provider")
    public Object[][] findMethod() {
        return new Object[][]{{"David"}};
    }
    @Test(dataProvider = "ValidFirstName-provider")
    public void getEmployeesById(String data) {
        employeesDAO.getEmployeesById(Integer.parseInt(data));
        Assert.assertEquals(data, "David");
    }
}
