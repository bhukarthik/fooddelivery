package bin;

public class Menus {
    private int menuId;
    private String itemName;
    private float price;
    private int couponId;
    private int cuisineId;
    private int restaurantId;
    private int menuItemsId;

    public Menus() {
    }

    public Menus(int menuId, String itemName, float price, int couponId, int cuisineId, int restaurantId1, int menuItemsId) {
        this.menuId = menuId;
        this.itemName = itemName;
        this.price = price;
        this.couponId = couponId;
        this.cuisineId = cuisineId;
        this.restaurantId = restaurantId1;
        this.menuItemsId = menuItemsId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }


    public int getMenuItemsId() {
        return menuItemsId;
    }

    public void setMenuItemsId(int menuItemsId) {
        this.menuItemsId = menuItemsId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }


}
