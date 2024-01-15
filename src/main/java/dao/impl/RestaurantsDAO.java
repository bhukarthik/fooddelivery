package dao.impl;

import bin.Restaurants;
import dao.RestaurantsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantsDAO implements RestaurantsMapper {
    private Connection connection;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(RestaurantsDAO.class);
    public static final String restaurantsSQL = "insert into fooddelivery.restaurants(restaurant_id, restaurant_name, address, city, zip_code, phone_number, ratings_rating_id)values(?,?,?,?,?,?,?)";
    public static final String residSQL = "Select * from restaurants where restaurantId = ?";

    public RestaurantsDAO() {
        connection = ConnectionManager.get();
    }
    public void addRestaurants(Restaurants restaurants) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(restaurantsSQL);
            preparedStatement.setInt(1, restaurants.getRestaurantId());
            preparedStatement.setString(2, restaurants.getRestaurantName());
            preparedStatement.setString(3, restaurants.getAddress());
            preparedStatement.setString(4, restaurants.getCity());
            preparedStatement.setInt(5, restaurants.getZipCode());
            preparedStatement.setLong(6, restaurants.getPhoneNumber());
            preparedStatement.setInt(7, restaurants.getRatingId());
            preparedStatement.executeUpdate();
            LOGGER.info("Row Inserted into DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }

    }

    public Restaurants getRestaurantsById(int restaurantId) {
        Restaurants restaurants = new Restaurants();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(residSQL);
            preparedStatement.setInt(1, restaurantId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                restaurants.setRestaurantId(rs.getInt("restaurant_id"));
                restaurants.setRestaurantName(rs.getString("restaurant_name"));
                restaurants.setAddress(rs.getString("address"));
                restaurants.setCity(rs.getString("city"));
                restaurants.setZipCode(rs.getInt("zip_code"));
                restaurants.setPhoneNumber(rs.getLong("phone_number"));
                restaurants.setRatingId(rs.getInt("rating_id"));
            }
            LOGGER.info("Restaurant ID " + restaurants.getRestaurantId());
            LOGGER.info("Restaurant Name " + restaurants.getRestaurantName());
            LOGGER.info("Address " + restaurants.getAddress());
            LOGGER.info("City " + restaurants.getCity());
            LOGGER.info("Zip Code " + restaurants.getZipCode());
            LOGGER.info("Phone Number " + restaurants.getPhoneNumber());
            LOGGER.info("Rating Id " + restaurants.getRatingId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
        return restaurants;
    }
}
