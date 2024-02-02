package service;

import bin.Employees;
import bin.Restaurants;

public interface RestuarantsService {
    public void createRestaurants();
    public void getRestaurantId();

    public void getTopRestaurants(int ratings);

}
