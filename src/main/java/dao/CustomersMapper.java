package dao;

import bin.Customers;
import bin.Restaurants;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CustomersMapper {
    @Insert("INSERT INTO fooddelivery.customers (cusid,first_name,last_name,address,city,state,zipcode,phone_number,email_id)VALUES (#{cusId},#{firstName},#{lastName},#{address},#{city},#{state},#{zipCode},#{phone_number},#{emailId})")
    public void addCustomers(Customers customers) ;
    @Results({
            @Result(property = "cusId", column = "cusid"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "zipcode", column = "zipcode"),
            @Result(property = "phone_number", column = "phone_number"),
            @Result(property = "emailId", column = "email_id")
    })
    @Select("Select * from fooddelivery.customers where cusid = #{cusId}")
    public Customers getCustomersByID(int cusId);
}
