package bin;

public class Coupons {
    private int couponId;
    private String couponCode;
    private int menuId;
    private int restaurantId;
    private int customerId;
    private int cartId;

    public Coupons(int couponId, String couponCode, int menuId, int restaurantId, int customerId, int cartId) {
        this.couponId = couponId;
        this.couponCode = couponCode;
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.cartId = cartId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
