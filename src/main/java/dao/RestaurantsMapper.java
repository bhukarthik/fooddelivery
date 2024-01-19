package dao;

import bin.Restaurants;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RestaurantsMapper {

    @Insert("INSERT INTO fooddelivery.restaurants (restaurant_id, restaurant_name, address, city, zip_code, phone_number, ratings_rating_id, orders_order_id)VALUES (#{restaurantId},#{restaurantName},#{address},#{city},#{zipCode},#{phoneNumber},#{ratingId},#{order_id})")
    public void addRestaurants(Restaurants restaurants);
    @Results({
            @Result(property = "restaurantId", column = "restaurant_id"),
            @Result(property = "restaurantName", column = "restaurant_name"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "zipcode", column = "zipcode"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "ratingId", column = "ratings_rating_id"),
            @Result(property = "order_id", column = "orders_order_id")
    })
    @Select("Select * from fooddelivery.restaurants where restaurantId = #{restaurantId}")
    public Restaurants getRestaurantsById(int restaurantId);
}
