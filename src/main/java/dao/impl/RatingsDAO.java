package dao.impl;

import bin.Customers;
import bin.Employees;
import bin.Ratings;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingsDAO {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(RatingsDAO.class);
    public static final String ratingsSQL = "select * from employees where empid=?";
    public static final String rateidSqL = "SELECT * FROM fooddelivery.ratings where CAST(rating_code as DECIMAL) = CAST(? AS DECIMAL)";

    public void addRatings(Ratings ratings) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(ratingsSQL)){
            preparedStatement.setInt(1, ratings.getRatingId());
            preparedStatement.setFloat(2, ratings.getRatingCode());
            preparedStatement.setInt(3, ratings.getCustomerId());
            preparedStatement.setString(4, ratings.getCustomerName());
            preparedStatement.setString(5, ratings.getRestaurantName());
            preparedStatement.setInt(6, ratings.getRestaurantId());
            preparedStatement.executeUpdate();
            LOGGER.info("Row Inserted into DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
            ConnectionManager.closePool();
        }
    }
   public void findRatingByCode(float ratingCode ) {
        LOGGER.info("Rating value "+ratingCode);
        Ratings ratings = new Ratings();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(rateidSqL)){
            preparedStatement.setFloat(1,ratingCode);
            try(ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    ratings.setRatingId(rs.getInt("rating_id"));
                    ratings.setRatingCode(rs.getFloat("rating_code"));
                    ratings.setCustomerId(rs.getInt("customer_id"));
                    ratings.setCustomerName(rs.getString("customer_name"));
                    ratings.setRestaurantName(rs.getString("restaurant_name"));
                    ratings.setRestaurantId(rs.getInt("restaurant_id"));
                }
                LOGGER.info("Rating Id" + ratings.getRatingId());
                LOGGER.info("Rating Code" + ratings.getRatingCode());
                LOGGER.info("Customer Id" + ratings.getCustomerId());
                LOGGER.info("Customer Name" + ratings.getCustomerName());
                LOGGER.info("Restaurant Name" + ratings.getRestaurantName());
                LOGGER.info("Restaurant Id" + ratings.getRestaurantId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
    }

}
