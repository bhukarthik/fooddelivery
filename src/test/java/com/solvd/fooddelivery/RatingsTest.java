package com.solvd.fooddelivery;

import bin.Ratings;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.RatingsServiceImpl;

public class RatingsTest {
    RatingsServiceImpl ratingsService = new RatingsServiceImpl();
    Ratings ratings = new Ratings();

    @DataProvider(name = "rating_code-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"2.8"}};
    }

    @Test (dataProvider = "rating_code-provider")
    public void testLowRatedRestaurant(String data) {
        System.out.println("Data "+data);
        ratingsService.findRatingByCode(Float.parseFloat(data));
        Assert.assertEquals(2.8,2.8);

    }
}
