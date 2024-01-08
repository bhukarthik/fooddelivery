package bin;

public class MenuItems {
    private int id;
    private int menuId;
    private String description;
    private float price;
    private String menuName;

    public MenuItems(int id, int menuId, String description, float price, String menuName) {
        this.id = id;
        this.menuId = menuId;
        this.description = description;
        this.price = price;
        this.menuName = menuName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


}
