package bin;

public class Cuisines {

    private int cuisineId;
    private String cuisineName;
    private int menuId;
    private String menuName;

    public Cuisines(int cuisineId, String cuisineName, int menuId, String menuName) {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
