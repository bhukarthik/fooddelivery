package bin;

public class Ratings {
    private int ratingId;
    private float ratingCode;
    private int customerId;
    private String customerName;
    private String restaurantName;
    private int restaurantId;

    public Ratings(int ratingId, float ratingCode, int customerId, String customerName, String restaurantName, int restaurantId) {
        this.ratingId = ratingId;
        this.ratingCode = ratingCode;
        this.customerId = customerId;
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
    }
    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public float getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(float ratingCode) {
        this.ratingCode = ratingCode;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


}
