package dao.impl;

import bin.Restaurants;
import dao.RestaurantsMapper;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantsDAO implements RestaurantsMapper {
    private Connection connection;

    public RestaurantsDAO() {
        connection = DButil.getConnection();
    }

    public void addRestaurants(Restaurants restaurants) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fooddelivery.restaurants(restaurant_id, restaurant_name, address, city, zip_code, phone_number, ratings_rating_id)values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, restaurants.getRestaurantId());
            preparedStatement.setString(2, restaurants.getRestaurantName());
            preparedStatement.setString(3, restaurants.getAddress());
            preparedStatement.setString(4, restaurants.getCity());
            preparedStatement.setInt(5,restaurants.getZipCode());
            preparedStatement.setLong(6, restaurants.getPhoneNumber());
            preparedStatement.setInt(7, restaurants.getRatingId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Restaurants getRestaurantsById(int restaurantId) {
        Restaurants restaurants = new Restaurants();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from restaurants where restaurantId = ?");
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return restaurants;
    }


}
