package dao;

import bin.Restaurants;

public interface RestaurantsMapper {
    public void addRestaurants(Restaurants restaurants) ;
    public Restaurants getRestaurantsById(int restaurantId);
}
