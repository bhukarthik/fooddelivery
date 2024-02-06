package dao.impl;

import bin.Employees;
import bin.TransportationModes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportationModeDAO {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(TransportationModeDAO.class);
    public static final String modeSQL = "SELECT * FROM fooddelivery.transportationmodes WHERE vehicle_name=?";

    public void getVehicleModeByName(String vehicleNAme) {
        TransportationModes transportationModes = new TransportationModes();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(modeSQL)) {
            preparedStatement.setString(1, vehicleNAme);
            try (ResultSet rs = preparedStatement.executeQuery();) {
                if (rs.next()) {
                    transportationModes.setVehicleId(rs.getInt("vehicleid"));
                    transportationModes.setVehicleName(rs.getString("vehicle_name"));
                    transportationModes.setVehicleStatus(rs.getString("vehicle_status"));
                    transportationModes.setEmpId(rs.getInt("empid"));
                    transportationModes.setOrderId(rs.getInt("orders_order_id"));
                }
                LOGGER.info("Vehicle Id" + transportationModes.getVehicleId());
                LOGGER.info("Vehicle Name" + transportationModes.getVehicleName());
                LOGGER.info("Vehile Status" + transportationModes.getVehicleStatus());
                LOGGER.info("Employee Id" + transportationModes.getEmpId());
                LOGGER.info("Order Id" + transportationModes.getOrderId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionManager.closePool();
        }
    }
}

