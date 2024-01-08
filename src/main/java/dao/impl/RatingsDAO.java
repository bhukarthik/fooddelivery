package dao.impl;

import bin.Employees;
import bin.Ratings;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RatingsDAO {
    private final Connection connection;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(RatingsDAO.class);

    public RatingsDAO() {
        connection = DButil.getConnection();
    }
    public void addRatings(Ratings ratings) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fooddelivery.ratings(rating_id,rating_code,customer_id,customer_name,restaurant_name,restaurant_id)values(?,?,?,?,?,?)");
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
    }
}
