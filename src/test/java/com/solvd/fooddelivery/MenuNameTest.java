package com.solvd.fooddelivery;

import bin.Menus;
import dao.impl.MenuDAO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MenuNameTest {
    MenuDAO menuDAO = new MenuDAO();
    Menus menus = new Menus();

    @DataProvider(name = "ItemName-provider")
    public Object[][] findMethod() {
        return new Object[][]{{"EGG"}};
    }
    @Test(dataProvider = "ItemName-provider")
    public void getItemName(String data) {
        menuDAO.getItemName(data);
        Assert.assertEquals(data, "EGG");
    }
}
