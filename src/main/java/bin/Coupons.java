package bin;

public class Coupons {
    private int coupon_id;
    private String coupon_code;
    private int menu_id;
    private int restaurant_id;
    private int customer_id;
    private int cart_id;

    public Coupons() {
    }

    public Coupons(int coupon_id, String coupon_code, int menu_id, int restaurant_id, int customer_id, int cart_id) {
        this.coupon_id = coupon_id;
        this.coupon_code = coupon_code;
        this.menu_id = menu_id;
        this.restaurant_id = restaurant_id;
        this.customer_id = customer_id;
        this.cart_id = cart_id;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    @Override
    public String toString() {
        return "Coupons{" +
               "coupon_id=" + coupon_id +
               ", coupon_code='" + coupon_code + '\'' +
               ", menu_id=" + menu_id +
               ", restaurant_id=" + restaurant_id +
               ", customer_id=" + customer_id +
               ", cart_id=" + cart_id +
               '}';
    }
}
