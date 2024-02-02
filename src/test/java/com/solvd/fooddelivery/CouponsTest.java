package com.solvd.fooddelivery;

import bin.Coupons;
import dao.impl.CouponsDAO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CouponsTest {

    @DataProvider(name="coupons-provider")
    public Object[] dpMethod(){
        return new Object[] {new Coupons (151,"FREE",14,205,101,10)};
    }
    @Test (dataProvider = "coupons-provider")
    public void addCouponTest(Coupons coupons){
        CouponsDAO couponsDAO = new CouponsDAO();
        couponsDAO.addCoupons(coupons);
        Assert.assertEquals(coupons,coupons, "Rows Updated");
    }

}
