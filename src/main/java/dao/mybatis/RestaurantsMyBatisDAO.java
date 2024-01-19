package dao.mybatis;

import bin.Customers;
import bin.Restaurants;
import dao.CustomersMapper;
import dao.EmployeesMapper;
import dao.RestaurantsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.MyBatisUtil;

import static util.MyBatisUtil.sesFact;

public class RestaurantsMyBatisDAO implements RestaurantsMapper {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(RestaurantsMyBatisDAO.class);
    @Override
    public void addRestaurants(Restaurants restaurants) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            RestaurantsMapper userMapper = sqlSession.getMapper(RestaurantsMapper.class);
            userMapper.addRestaurants(restaurants);
            sqlSession.commit();
            LOGGER.info("Restaurants Record Created");
        }finally{
            sqlSession.close();
        }
    }
    @Override
    public Restaurants getRestaurantsById(int restaurantId) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            RestaurantsMapper userMapper = sqlSession.getMapper(RestaurantsMapper.class);
            Restaurants restaurants= userMapper.getRestaurantsById(restaurantId);
            LOGGER.info("Restaurants Id "+restaurants.getRestaurantId());
            LOGGER.info("Restaurants Name "+restaurants.getRestaurantName());
            LOGGER.info("Restaurants Address "+restaurants.getAddress());
            LOGGER.info("Restaurants City "+restaurants.getCity());
            LOGGER.info("Restaurants Zipcode "+restaurants.getZipCode());
            LOGGER.info("Phone Number "+restaurants.getPhoneNumber());
            LOGGER.info("Rating ID "+restaurants.getRatingId());
            LOGGER.info("Order ID "+restaurants.getOrder_id());
            return restaurants;
        }finally{
            sqlSession.close();
        }
    }
}
