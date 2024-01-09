package bin;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="vehicle")
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

    @XmlAttribute(name="id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    @XmlElement(name = "vehicle_name")
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    @XmlElement(name = "vehicle_status")
    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    @XmlElement(name = "empid")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    @XmlElement(name ="orders_order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "TransportationModes{" +
               "vehicleId=" + vehicleId +
               ", vehicleName='" + vehicleName + '\'' +
               ", vehicleStatus='" + vehicleStatus + '\'' +
               ", empId=" + empId +
               ", orderId=" + orderId +
               '}';
    }
}
