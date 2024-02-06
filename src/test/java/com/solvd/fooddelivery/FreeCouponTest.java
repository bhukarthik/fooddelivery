package com.solvd.fooddelivery;

import bin.Coupons;
import dao.impl.CouponsDAO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FreeCouponTest {
    CouponsDAO couponsDAO = new CouponsDAO();
    Coupons coupons = new Coupons();

    @DataProvider(name = "free-coupons")
    public Object[][] findMethod() {
        return new Object[][]{{"FREE"}};
    }

    @Test(dataProvider = "free-coupons")
    public void findCouponsCodeTest(String couponCode) {
        CouponsDAO couponsDAO = new CouponsDAO();
        couponsDAO.findByCouponCode(couponCode);

    }
}
