import bin.Customers;
import bin.Employees;
import bin.Restaurants;
import bin.TransportationModes;
import dao.impl.DOMParserDAO;
import javax.xml.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import service.CustomersService;
import service.EmployeesService;
import service.RestuarantsService;
import service.impl.CustomersServiceImpl;
import service.impl.EmployeesServiceImpl;
import service.impl.RestaurantsServiceImpl;
import util.DButil;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

public class FoodDeliveryMain {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(FoodDeliveryMain.class);
    public static void main(String[] args) {
        FoodDeliveryMain obj = new FoodDeliveryMain();
        LOGGER.info("Welcome To Online Food Delivery ");
        LOGGER.info("Please follow the below Menu");
        int choice;
        Scanner mainMenu = new Scanner(System.in);
        LOGGER.info("1. Employee Adding ");
        LOGGER.info("2. Customer Adding ");
        LOGGER.info("3. Restaurants Adding ");
        LOGGER.info("4. Find Employees ");
        LOGGER.info("5. Find Customers ");
        LOGGER.info("6. Find Restaurants ");
        LOGGER.info("7. Find Total Employee (using MyBatis) ");
        LOGGER.info("8. Submit Ratings (DOM Parser) ");
        LOGGER.info("9. Transportation Modes (JAXB Parser) ");
        LOGGER.info("Enter You Choice [1-9] :");
        choice = mainMenu.nextInt();

        switch (choice) {
            case 1:
                obj.employeeInsert();
                break;
            case 2:
                obj.customerInsert();
                break;
            case 3:
                obj.restaurantsInsert();
                break;
            case 4:
                obj.findEmployee();
                break;
            case 5:
                obj.findCustomers();
                break;
            case 6:
                obj.findRestaurants();
                break;
            case 7:
                obj.employeeTotalCount();
                break;
            case 8:
                obj.domParser();
                break;
            case 9:
                obj.transportationModes();
                break;
        }
        try {
            DButil.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void employeeInsert(){
        Employees employees = new Employees(108,"Mike","Hussy",4082089192L);
        EmployeesService employeesService = new EmployeesServiceImpl();
        employeesService.createEmployees(employees);
    }
    public void employeeTotalCount(){
        EmployeesService employeesServiceObj = new EmployeesServiceImpl();
        employeesServiceObj.getNumberOfEmployees();
    }
    public void domParser(){
        DOMParserDAO domParserDAO = new DOMParserDAO("src/main/resources/rating.xml");
        try {
            domParserDAO.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void findEmployee(){
        EmployeesServiceImpl employeesServiceObj1= new EmployeesServiceImpl();
        employeesServiceObj1.getEmployeeId(120);
    }
    public void customerInsert(){
        Customers customers = new Customers(104,"Sam","Smith","204 Mebane RD","Mebane","NC",27273,54252341235L,"ssmith@gmail.com");
        CustomersService customersService = new CustomersServiceImpl();
        customersService.createCustomers(customers);
    }
    public void findCustomers(){
        CustomersService customersServiceObj = new CustomersServiceImpl();
        customersServiceObj.getCustomerId(104);
    }
    public void restaurantsInsert(){
        Restaurants restaurants = new Restaurants(205, "Chick-fil-A", "140 N Main St", "Varina", 27539, 8541236754L, 3);
        RestuarantsService restuarantsService = new RestaurantsServiceImpl();
        restuarantsService.createRestaurants(restaurants);
    }
    public void findRestaurants(){
        RestuarantsService restaurantsServiceObj = new RestaurantsServiceImpl();
        restaurantsServiceObj.getRestaurantId(205);
    }
    public void transportationModes(){
        try {
            File file = new File("src/main/resources/transportationmodes.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(bin.TransportationModes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TransportationModes transportationModesObj=(TransportationModes) jaxbUnmarshaller.unmarshal(file);
            LOGGER.info("Available Transportation Vehicle Id " +transportationModesObj.getVehicleId()+ " Vehicle Name " +transportationModesObj.getVehicleName()+ "Order Id" +transportationModesObj.getOrderId());
            //System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
