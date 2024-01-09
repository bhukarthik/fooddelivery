package dao.impl;

import bin.Coupons;
import bin.Ratings;
import dao.CouponsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CouponsDAO implements CouponsMapper {

    private final Connection connection;
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CouponsDAO.class);

    public CouponsDAO() {
        connection = DButil.getConnection();
    }

    public void addCoupons(Coupons coupons) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fooddelivery.coupons(coupon_id,coupon_code,menu_id,restaurant_id,customer_id,cart_id) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, coupons.getCoupon_id());
            preparedStatement.setString(2, coupons.getCoupon_code());
            preparedStatement.setInt(3, coupons.getMenu_id());
            preparedStatement.setInt(4, coupons.getRestaurant_id());
            preparedStatement.setInt(5, coupons.getCustomer_id());
            preparedStatement.setInt(6, coupons.getCart_id());
            preparedStatement.executeUpdate();
            LOGGER.info("Row Inserted into DB");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
