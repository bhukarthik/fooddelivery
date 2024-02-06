package com.solvd.fooddelivery;

import bin.Menus;
import dao.impl.MenuDAO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MenuPriceTest {
    MenuDAO menuDAO = new MenuDAO();
    Menus menus = new Menus();



    @DataProvider(name = "itemPrice-provider")
    public Object[][] PriceMethod() {
        return new Object[][]{{"11.99"}};
    }



    @Test(dataProvider = "itemPrice-provider")
    public void getItemPrice(String data) {
        menuDAO.getItemPrice(Float.parseFloat(data));
        Assert.assertEquals(data, "11.99");
    }


}
