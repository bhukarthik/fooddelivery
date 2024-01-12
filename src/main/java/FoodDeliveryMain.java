import bin.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import dao.impl.DOMParserDAO;
import javax.xml.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.xml.sax.SAXException;
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
        LOGGER.info("7. Find Total Employee (using MyBatis) ");
        LOGGER.info("8. Submit Ratings (DOM Parser) ");
        LOGGER.info("9. Transportation Modes (JAXB Parser) ");
        LOGGER.info("10.Coupons Adding (JACKSON Parser) ");
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
        Employees employees = new Employees(108,"Mike","Hussy",4082089192L,"Car1");
        EmployeesServiceImpl employeesService = new EmployeesServiceImpl();
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
        CustomersServiceImpl customersService = new CustomersServiceImpl();
        customersService.createCustomers(customers);
    }
    public void findCustomers(){
        CustomersServiceImpl customersServiceObj = new CustomersServiceImpl();
        customersServiceObj.getCustomerId(104);
    }
    public void restaurantsInsert(){
        Restaurants restaurants = new Restaurants(205, "Chick-fil-A", "140 N Main St", "Varina", 27539, 8541236754L, 3);
        RestaurantsServiceImpl restuarantsService = new RestaurantsServiceImpl();
        restuarantsService.createRestaurants(restaurants);
    }
    public void findRestaurants(){
        RestuarantsService restaurantsServiceImplObj = new RestaurantsServiceImpl();
        restaurantsServiceImplObj.getRestaurantId(205);
    }
    public void transportationModes()  {
        try {
            File file = new File("src/main/resources/transportationmodes.xml");
            File xsdFile = new File("src/main/resources/vehicle.xsd");
            JAXBContext jaxbContext = JAXBContext.newInstance(bin.TransportationModes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            TransportationModes transportationModesObj=(TransportationModes) jaxbUnmarshaller.unmarshal(file);
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema vehicleSchema = sf.newSchema(xsdFile);
            jaxbUnmarshaller.setSchema(vehicleSchema);
            LOGGER.info("Transportation Modes"+transportationModesObj);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    public void addingCoupons() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonData = new File("src/main/resources/Coupons.json");
        List<Coupons> coupons = objectMapper.readValue(jsonData, new TypeReference<>(){});
        LOGGER.info("coupons Object\n"+coupons);

        /*objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, coupons);
        LOGGER.info("Coupons JSON is\n"+stringEmp);
        JSONPObject jsonpObject = new JSONPObject(stringEmp);

        //Coupons couponsObj = new Coupons();
        //couponsObj.setCoupon_id(stringEmp);*/
    }
}
