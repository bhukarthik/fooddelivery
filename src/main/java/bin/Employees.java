package bin;

public class Employees {
    private int empId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String transportationmodesvehicleid;

    public Employees(int empId, String firstName, String lastName, long phoneNumber, String transportationmodesvehicleid) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.transportationmodesvehicleid = transportationmodesvehicleid;
    }

    public Employees() {

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTransportationmodesvehicleid() {
        return transportationmodesvehicleid;
    }

    public void setTransportationmodesvehicleid(String transportationmodesvehicleid) {
        this.transportationmodesvehicleid = transportationmodesvehicleid;
    }
}
