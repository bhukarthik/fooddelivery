package com.solvd.fooddelivery;

import bin.Customers;
import bin.Restaurants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.CustomersServiceImpl;
import service.impl.RestaurantsServiceImpl;

public class CustomersTest {
    CustomersServiceImpl customersService= new CustomersServiceImpl();
    Customers customers = new Customers();

    @DataProvider (name="phoneNumber-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"8019792024"}};
    }

    @Test (dataProvider = "phoneNumber-provider")
    public void testFindCustomerByPhone(String data){
        System.out.println("Data"+data);
        customersService.getCustomerIdbyPhone(data);
        Assert.assertEquals(data,"8019792024");
    }
}
