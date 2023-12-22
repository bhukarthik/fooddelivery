package dao;

import bin.Customers;
import bin.Restaurants;

public interface CustomersMapper {
    public void addCustomers(Customers customers) ;
    public Customers getCustomersByID(int cusId);
}
