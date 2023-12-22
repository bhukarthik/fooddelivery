package service.impl;

import bin.Employees;
import bin.Restaurants;
import dao.impl.EmployeesDAO;
import dao.impl.RestaurantsDAO;
import service.RestuarantsService;

public class RestaurantsServiceImpl implements RestuarantsService {
    RestaurantsDAO restaurantsDAO = new RestaurantsDAO();
    @Override
    public void createRestaurants(Restaurants restaurants) {
        restaurantsDAO.addRestaurants(restaurants);
    }
    @Override
    public void getRestaurantId(int id) {

    }
}
