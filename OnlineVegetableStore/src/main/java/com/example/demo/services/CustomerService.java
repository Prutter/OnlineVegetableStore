package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Customer;



public interface CustomerService {
 public Customer addCustomer(Customer customer);
 public Customer updateCustomer(Customer customer);
 public Customer removeCustomer(Customer customer);
 public Customer viewCustomer(Customer customer);
 public List<Customer> viewCustomerList();
 
}
