package service.impl;

import bin.Employees;
import bin.Restaurants;
import dao.impl.EmployeesDAO;
import dao.impl.RestaurantsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import service.RestuarantsService;

import java.util.Scanner;

public class RestaurantsServiceImpl implements RestuarantsService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(RestaurantsServiceImpl.class);
    RestaurantsDAO restaurantsDAO = new RestaurantsDAO();
    @Override
    public void createRestaurants() {
        Scanner myObj = new Scanner(System.in);
        LOGGER.info("Enter the Restaurant ID ");
        int restaurantId = myObj.nextInt();
        LOGGER.info("Enter the Restaurant Name ");
        String restaurantName = myObj.nextLine();
        LOGGER.info("Enter the Restaurant Address");
        String address = myObj.nextLine();
        LOGGER.info("Enter the City");
        String city = myObj.nextLine();
        LOGGER.info("Enter the Zipcode");
        int zipCode = myObj.nextInt();
        LOGGER.info("Enter the PhoneNumber");
        long phoneNumber =  myObj.nextLong();
        LOGGER.info("Enter the Rating ");
        int rating = myObj.nextInt();
        int orderId = 1001;
        Restaurants restaurants = new Restaurants(restaurantId,restaurantName,address,city,zipCode,phoneNumber,rating,orderId);
        restaurantsDAO.addRestaurants(restaurants);
    }
    @Override
    public void getRestaurantId() {
        Scanner myObj1 = new Scanner(System.in);
        LOGGER.info("Enter the Restaurant ID ");
        int id = myObj1.nextInt();
        restaurantsDAO.getRestaurantsById(id);
    }
    public void getTopRestaurants(int ratings){
        Restaurants restaurants = new Restaurants();
        restaurantsDAO.getTopRestaurantsById(ratings);
        if(restaurants.getRatingId()==5){
            LOGGER.info("Elite Restaurant");
        }
        else if (restaurants.getRatingId() ==4){
            LOGGER.info("Premium Restaurant");
        }
        else if (restaurants.getRatingId() ==3){
            LOGGER.info("Class A Restaurant");
        }
        else if (restaurants.getRatingId() ==2){
            LOGGER.info("Class B Restaurant");
        }
        else if (restaurants.getRatingId() ==1){
            LOGGER.info("Class C Restaurant");
        }
    }
}
