package dao.mybatis;

import bin.Customers;
import bin.Employees;
import dao.CustomersMapper;
import dao.EmployeesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.MyBatisUtil;

import static util.MyBatisUtil.sesFact;

public class CustomerMyBatisDAO implements CustomersMapper {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(CustomerMyBatisDAO.class);
    @Override
    public void addCustomers(Customers customers) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            CustomersMapper userMapper = sqlSession.getMapper(CustomersMapper.class);
            userMapper.addCustomers(customers);
            sqlSession.commit();
            LOGGER.info("Customer Record Created");
        }finally{
            sqlSession.close();
        }
    }

    @Override
    public Customers getCustomersByID(int cusId) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            CustomersMapper userMapper = sqlSession.getMapper(CustomersMapper.class);
            Customers customers= userMapper.getCustomersByID(cusId);
            LOGGER.info("Customer Id "+customers.getCusId());
            LOGGER.info("Customer First Name "+customers.getFirstName());
            LOGGER.info("Customer Last Name "+customers.getLastName());
            LOGGER.info("Customer Address "+customers.getAddress());
            LOGGER.info("Customer City "+customers.getCity());
            LOGGER.info("Customer State "+customers.getState());
            LOGGER.info("Customer Zipcode "+customers.getZipCode());
            LOGGER.info("Customer Phone Number "+customers.getPhone_number());
            LOGGER.info("Customer Email "+customers.getEmailId());
            return customers;
        }finally{
            sqlSession.close();
        }
    }
}
