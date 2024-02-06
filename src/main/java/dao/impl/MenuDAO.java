package dao.impl;

import bin.Menus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDAO {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(MenuDAO.class);
    private static final String itemSQL = "SELECT * FROM fooddelivery.menus WHERE item_name like ?";
    private static final String priceSQL = "SELECT * FROM fooddelivery.menus WHERE cast(price as DECIMAL) = cast(? as DECIMAL)";

    public void getItemName(String itemName) {
        Menus menus = new Menus();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(itemSQL)) {
            preparedStatement.setString(1, "%" + itemName + "%");
            try (ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    menus.setMenuId(rs.getInt("menu_id"));
                    menus.setItemName(rs.getString("item_name"));
                    menus.setPrice(rs.getFloat("price"));

                    LOGGER.info("Menu Id" + menus.getMenuId());
                    LOGGER.info("Item Name" + menus.getItemName());
                    LOGGER.info("Price" + menus.getPrice());
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void getItemPrice ( float itemPrice){
            Menus menus = new Menus();
            try (Connection connection = ConnectionManager.get();
                 PreparedStatement preparedStatement = connection.prepareStatement(priceSQL)) {
                preparedStatement.setFloat(1, itemPrice);
                try (ResultSet rs = preparedStatement.executeQuery();) {
                    if (rs.next()) {
                        menus.setMenuId(rs.getInt("menu_id"));
                        menus.setItemName(rs.getString("item_name"));
                        menus.setPrice(rs.getFloat("price"));
                    }
                    LOGGER.info("Menu Id" + menus.getMenuId());
                    LOGGER.info("Item Name" + menus.getItemName());
                    LOGGER.info("Price" + menus.getPrice());

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionManager.closePool();
            }
        }
    }

























