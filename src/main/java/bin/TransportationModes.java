package bin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class TransportationModes {
    private int vehicleId;
    private String vehicleName;
    private String vehicleStatus;
    private int empId;
    private int orderId;

    public TransportationModes(int vehicleId, String vehicleName, String vehicleStatus, int empId, int orderId) {
        super();
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleStatus = vehicleStatus;
        this.empId = empId;
        this.orderId = orderId;
    }

    public TransportationModes() {
    }

    @XmlAttribute
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    @XmlElement
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    @XmlElement
    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    @XmlElement
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    @XmlElement
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


}
