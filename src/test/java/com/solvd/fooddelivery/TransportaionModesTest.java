package com.solvd.fooddelivery;

import bin.TransportationModes;
import dao.impl.TransportationModeDAO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TransportationMode;
import service.impl.TransportationModeImpl;

public class TransportaionModesTest {
    TransportationModeDAO transportationModeDAO = new TransportationModeDAO();
    TransportationModes transportationModes = new TransportationModes();

    @DataProvider(name="vehicleName-provider")
    public Object[][] findMethod(){ return new Object[][] {{"bike"}};}

    @Test(dataProvider ="vehicleName-provider")
    public void testFindVehicleByName(String data){
    transportationModeDAO.getVehicleModeByName(data);
    Assert.assertEquals(data,"car");
    }

}
