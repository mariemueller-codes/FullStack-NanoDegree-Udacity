package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import model.Customer;

public class CustomerService {

    private static CustomerService SINGLETON = new CustomerService();

    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(String email, String firstName, String lastName){
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public static CustomerService getSingleton(){return SINGLETON;}

    public Customer getCustomer(String customerEmail){
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomer(){return customers.values();}
}
