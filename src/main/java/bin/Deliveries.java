package bin;

public class Deliveries {
    private int deliveryId;
    private String deliveryMode;
    private String employeeName;
    private int employeePhoneNumber;
    private int customerId;
    private String customerName;
    private Long customerPhoneNumber;
    private int orderId;

    public Deliveries(int deliveryId, String deliveryMode, String employeeName, int employeePhoneNumber, int customerId, String customerName, long customerPhoneNumber, int orderId) {
        this.deliveryId = deliveryId;
        this.deliveryMode = deliveryMode;
        this.employeeName = employeeName;
        this.employeePhoneNumber = employeePhoneNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderId = orderId;
    }


    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(int employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(long customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


}
