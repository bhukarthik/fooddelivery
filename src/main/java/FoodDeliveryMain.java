import bin.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import dao.impl.CouponsDAO;
import dao.impl.DOMParserDAO;
import javax.xml.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.xml.sax.SAXException;
import service.*;
import service.impl.*;
import util.DButil;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FoodDeliveryMain {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(FoodDeliveryMain.class);
    public static void main(String[] args) throws IOException {
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
        LOGGER.info("7. Find Total Employee ");
        LOGGER.info("8. Submit Ratings");
        LOGGER.info("9. Add Transportation Modes (JAXB Parser) ");
        LOGGER.info("10.Add Coupons Adding (JACKSON Parser) ");
        LOGGER.info("Enter You Choice [1-10] :");
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
            case 10:
                obj.addingCoupons();
                break;
        }
        try {
            DButil.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void employeeInsert(){
        Employees employees = new Employees();
        EmployeesService employeesService = new EmployeesServiceImpl();
        employeesService.createEmployees(employees);
    }
    public void employeeTotalCount(){
        EmployeesServiceImpl employeesServiceObj = new EmployeesServiceImpl();
        employeesServiceObj.getEmployeeId();
    }
    public void domParser(){
        DOMParserImpl domParser = new DOMParserImpl();
        domParser.parseImp();
    }
    public void findEmployee(){
        EmployeesService employeesServiceObj1= new EmployeesServiceImpl();
        employeesServiceObj1.getEmployeeId();
    }
    public void customerInsert(){

        CustomersService customersService = new CustomersServiceImpl();
        customersService.createCustomers();
    }
    public void findCustomers(){
        CustomersService customersServiceObj = new CustomersServiceImpl();
        customersServiceObj.getCustomerId();
    }
    public void restaurantsInsert(){
        RestuarantsService restuarantsService = new RestaurantsServiceImpl();
        restuarantsService.createRestaurants();

    }
    public void findRestaurants(){
        RestuarantsService restaurantsServiceImplObj = new RestaurantsServiceImpl();
        restaurantsServiceImplObj.getRestaurantId();
    }
    public void transportationModes()  {
        TransportationMode transportationMode = new TransportationModeImpl();
        transportationMode.addTransportation();
    }
    public void addingCoupons()  {
        CouponsService couponsServiceObj = new CouponsServiceImpl();
        couponsServiceObj.createCoupons();
    }
}
