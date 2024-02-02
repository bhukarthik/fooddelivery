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

    private static final Logger LOGGER = (Logger) LogManager.getLogger(RestaurantsDAO.class);
    public static final String restaurantsSQL = "insert into fooddelivery.restaurants(restaurant_id, restaurant_name, address, city, zip_code, phone_number, ratings_rating_id,orders_order_id)values(?,?,?,?,?,?,?,?)";
    public static final String residSQL = "Select * from restaurants where restaurant_id = ?";

    public static final String topRatedResSQL = "SELECT * FROM fooddelivery.restaurants WHERE ratings_rating_id=?";

      public void addRestaurants(Restaurants restaurants) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(restaurantsSQL)) {
            preparedStatement.setInt(1, restaurants.getRestaurantId());
            preparedStatement.setString(2, restaurants.getRestaurantName());
            preparedStatement.setString(3, restaurants.getAddress());
            preparedStatement.setString(4, restaurants.getCity());
            preparedStatement.setInt(5, restaurants.getZipCode());
            preparedStatement.setLong(6, restaurants.getPhoneNumber());
            preparedStatement.setInt(7, restaurants.getRatingId());
            preparedStatement.setInt(8, restaurants.getOrder_id());
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
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(residSQL)){
            preparedStatement.setInt(1, restaurantId);
            try(ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    restaurants.setRestaurantId(rs.getInt("restaurant_id"));
                    restaurants.setRestaurantName(rs.getString("restaurant_name"));
                    restaurants.setAddress(rs.getString("address"));
                    restaurants.setCity(rs.getString("city"));
                    restaurants.setZipCode(rs.getInt("zip_code"));
                    restaurants.setPhoneNumber(rs.getLong("phone_number"));
                    restaurants.setRatingId(rs.getInt("ratings_rating_id"));
                    restaurants.setOrder_id(rs.getInt("orders_order_id"));
                }
                LOGGER.info("Restaurant ID " + restaurants.getRestaurantId());
                LOGGER.info("Restaurant Name " + restaurants.getRestaurantName());
                LOGGER.info("Address " + restaurants.getAddress());
                LOGGER.info("City " + restaurants.getCity());
                LOGGER.info("Zip Code " + restaurants.getZipCode());
                LOGGER.info("Phone Number " + restaurants.getPhoneNumber());
                LOGGER.info("Rating Id " + restaurants.getRatingId());
                LOGGER.info("Order Id "+ restaurants.getOrder_id());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
        return restaurants;
    }
    public Restaurants getTopRestaurantsById(int ratingId) {
        Restaurants restaurants = new Restaurants();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(topRatedResSQL)){
            preparedStatement.setInt(1, ratingId);
            try(ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    restaurants.setRestaurantId(rs.getInt("restaurant_id"));
                    restaurants.setRestaurantName(rs.getString("restaurant_name"));
                    restaurants.setAddress(rs.getString("address"));
                    restaurants.setCity(rs.getString("city"));
                    restaurants.setZipCode(rs.getInt("zip_code"));
                    restaurants.setPhoneNumber(rs.getLong("phone_number"));
                    restaurants.setRatingId(rs.getInt("ratings_rating_id"));
                    restaurants.setOrder_id(rs.getInt("orders_order_id"));
                }
                LOGGER.info("Restaurant ID " + restaurants.getRestaurantId());
                LOGGER.info("Restaurant Name " + restaurants.getRestaurantName());
                LOGGER.info("Address " + restaurants.getAddress());
                LOGGER.info("City " + restaurants.getCity());
                LOGGER.info("Zip Code " + restaurants.getZipCode());
                LOGGER.info("Phone Number " + restaurants.getPhoneNumber());
                LOGGER.info("Rating Id " + restaurants.getRatingId());
                LOGGER.info("Order Id "+ restaurants.getOrder_id());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
        return restaurants;
    }

}
