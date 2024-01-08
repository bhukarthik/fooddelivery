package bin;

import java.util.Date;

public class OperatingHours {
    private int id;
    private Date openHours;
    private Date closeHour;
    private String operatingDay;
    private int restaurantId;

    public OperatingHours(int id, Date openHours, Date closeHour, String operatingDay, int restaurantId) {
        this.id = id;
        this.openHours = openHours;
        this.closeHour = closeHour;
        this.operatingDay = operatingDay;
        this.restaurantId = restaurantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOpenHours() {
        return openHours;
    }

    public void setOpenHours(Date openHours) {
        this.openHours = openHours;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
        this.closeHour = closeHour;
    }

    public String getOperatingDay() {
        return operatingDay;
    }

    public void setOperatingDay(String operatingDay) {
        this.operatingDay = operatingDay;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


}
