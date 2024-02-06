package dao.impl;

import bin.Coupons;
import bin.Ratings;
import dao.CouponsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CouponsDAO implements CouponsMapper {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(CouponsDAO.class);
    private static final String couponsSQL = "INSERT INTO fooddelivery.coupons(coupon_id,coupon_code,menu_id,restaurant_id,customer_id,cart_id) VALUES (?,?,?,?,?,?)";
    private static final String deleteCouponsSQL = "DELETE FROM fooddelivery.coupons where restaurant_id=?";
    private static final String FindCouponsSQL = "SELECT * FROM fooddelivery.coupons WHERE coupon_code = ?";

    public void addCoupons(Coupons coupons) {

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(couponsSQL)) {
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

     public void findByCouponCode(String couponCode) {
        Coupons coupons = new Coupons();
        try (Connection connection = ConnectionManager.get();
            PreparedStatement preparedStatement = connection.prepareStatement(FindCouponsSQL)) {
            preparedStatement.setString(1, couponCode);
            try (ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    coupons.setCoupon_id(rs.getInt("coupon_id"));
                    coupons.setCoupon_code(rs.getString("coupon_code"));
                    coupons.setMenu_id(rs.getInt("menu_id"));
                    coupons.setRestaurant_id(rs.getInt("restaurant_id"));
                    coupons.setCustomer_id(rs.getInt("customer_id"));
                    coupons.setCart_id(rs.getInt("cart_id"));
                }
                LOGGER.info("Coupon Id" + coupons.getCoupon_id());
                LOGGER.info("Coupon Code" + coupons.getCoupon_code());
                LOGGER.info("Menu Id" + coupons.getMenu_id());
                LOGGER.info("Restaurant Id" + coupons.getRestaurant_id());
                LOGGER.info("Customer Id" + coupons.getCustomer_id());
                LOGGER.info("Cart Id" + coupons.getCart_id());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.closePool();
        }
    }

}
