import bin.Customers;
import bin.Employees;
import bin.Restaurants;
import dao.impl.EmployeesDAO;
import service.CustomersService;
import service.EmployeesService;
import service.RestuarantsService;
import service.impl.CustomersServiceImpl;
import service.impl.EmployeesServiceImpl;
import service.impl.RestaurantsServiceImpl;
import util.DButil;

import java.sql.SQLException;

public class FoodDeliveryMain {
    public static void main(String[] args) {
        Employees employees = new Employees(103,"David","Cove",8019723381L);
        EmployeesService employeesService = new EmployeesServiceImpl();
        employeesService.createEmployees(employees);
        employeesService.getEmployeeId(120);
        Customers customers = new Customers(104,"Sam","Smith","204 Mebane RD","Mebane","NC",27273,54252341235L,"ssmith@gmail.com");
        CustomersService customersService = new CustomersServiceImpl();
        customersService.createCustomers(customers);
        customersService.getCustomerId(104);
        Restaurants restaurants = new Restaurants(205, "Chick-fil-A", "140 N Main St", "Varina", 27539, 8541236754L, 3);
        RestuarantsService restuarantsService = new RestaurantsServiceImpl();
        restuarantsService.createRestaurants(restaurants);
        restuarantsService.getRestaurantId(205);
        try {
            DButil.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
