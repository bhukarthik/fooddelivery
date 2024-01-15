package dao.impl;

import bin.Employees;
import bin.Ratings;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RatingsDAO {
    private final Connection connection;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(RatingsDAO.class);
public static final String ratingsSQL = "select * from employees where empid=?";
    public RatingsDAO() {

        connection = ConnectionManager.get();
    }
    public void addRatings(Ratings ratings) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ratingsSQL);
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
}
