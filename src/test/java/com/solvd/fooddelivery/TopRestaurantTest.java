package com.solvd.fooddelivery;


import bin.Restaurants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.impl.RestaurantsServiceImpl;

public class TopRestaurantTest {
    RestaurantsServiceImpl restaurantsService = new RestaurantsServiceImpl();
    Restaurants restaurants = new Restaurants();

    @DataProvider(name="restaurant-provider")
    public Object[][] findMethod(){ return new Object[][] {{"5"}};}

    @Test (dataProvider ="restaurant-provider")
    public void testFindTopRastaurant(String data) {
        restaurantsService.getTopRestaurants(Integer.parseInt(data));
        Assert.assertEquals(data, 5);

    }
}
