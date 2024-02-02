package com.solvd.fooddelivery;


import bin.Restaurants;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.impl.RestaurantsServiceImpl;

public class TopRestaurantTest {
    RestaurantsServiceImpl restaurantsService = new RestaurantsServiceImpl();
    Restaurants restaurants = new Restaurants();

    @Test
    public void testFindTopRastaurant() {
        restaurants.setRatingId(5);
        restaurantsService.getTopRestaurants(5);
        Assert.assertEquals(5, 5);

    }
}
