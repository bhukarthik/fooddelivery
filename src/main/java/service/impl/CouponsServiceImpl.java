package service.impl;

import bin.Coupons;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.CouponsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import service.CouponsService;
import service.CustomersService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CouponsServiceImpl implements CouponsService {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(CouponsServiceImpl.class);
    CouponsDAO couponsDAO = new CouponsDAO();
    @Override
    public void createCoupons() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonData = new File("src/main/resources/Coupons.json");
        List<Coupons> coupons = null;
        try {
            coupons = objectMapper.readValue(jsonData, new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("coupons Object\n"+coupons);
        Scanner myObj = new Scanner(System.in);
        LOGGER.info("Enter the Coupon ID ");
        int couponId = myObj.nextInt();
        LOGGER.info("Coupon Code ");
        String couponCode = myObj.nextLine();
        int menuId=19;
        int restaurantId=204;
        int customerId=104;
        int cartId= 10;
        Coupons couponsObj = new Coupons(couponId,couponCode,menuId,restaurantId,customerId,cartId);
        /*objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, coupons);
        LOGGER.info("Coupons JSON is\n"+stringEmp);
        JSONPObject jsonpObject = new JSONPObject(stringEmp);

        //Coupons couponsObj = new Coupons();
        //couponsObj.setCoupon_id(stringEmp);*/
        couponsDAO.addCoupons(couponsObj);
    }
}
