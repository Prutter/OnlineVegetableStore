package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Customer;
import com.example.demo.exceptions.AdminException;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.CustomerDao;

import ch.qos.logback.core.joran.conditional.IfAction;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	
	/**
	 * This method is used to add Customer details in  the database
	 * @paramCustomer 
	 * @return Customer
	 * @exception CustomerException
	 * @author Ankit choubey
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer>  res= customerDao.findByEmail(customer.getEmail());
		Customer obCustomer=null;
		if(res.isPresent())
			   throw new CustomerException("User already exits");
		else if(customer==null)
			  throw new CustomerException("provided detalis are empty");
		else {
			   
			 obCustomer = customerDao.save(customer);
		}
			
		
		return obCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Customer res= customerDao.findByEmail(customer.getEmail()).orElseThrow(()->new CustomerException("Customer details Not found"));
	   
	    
	    if(!customer.getEmail().equals(""))
		{
			res.setEmail(customer.getEmail());
			
		}
	   
	   
	    customerDao.save(res);
	   
			    
		return res;
	}

	
	/**
	 * This method is used to Delete a particular Customer using email address
	 * @paramCustomer
	 * @return Customer
	 * @exception CustomerNotFoundException
	 * @author Ankit choubey
	 */
	@Override
	public Customer removeCustomer(Customer customer) {
		Customer res= customerDao.findByEmail(customer.getEmail()).orElseThrow(()->new CustomerNotFoundException("Provided  customer details are invalid ,Please try again with correct details"));
		
		
		 customerDao.delete(res);
		 return res;
		
	}
	
	
    /**
     * This method is used to get Customer details either by Email or Phone number
     * @paramCustomer
     * @exception CustomerException
     * @return Customer
     * @author Ankit Choubey 
     */
	@Override
	public Customer viewCustomer(Customer customer) {
		
		
		if(!customer.getEmail().equals(""))
		{
			Customer ans = customerDao.findByEmail(customer.getEmail()).orElseThrow(()->new CustomerException("Invalid credential"));
			return ans;
		}
		
		if(!customer.getPhone().equals(""))
		{
			Customer ans = customerDao.findByPhone(customer.getPhone()).orElseThrow(()-> new CustomerException("Invalid Credential"));
			return ans;
		}
		else {
			 throw new CustomerNotFoundException("Details are invalid ,User not found");
		}
		
		
		
	}

	/**
	 * This method is used to get list of all the Customer
	 * @return List<Customer> 
	 * @param void
	 * @author Ankit choubey
	 * @exception CustomerException (if customer list is empty)
	 *
	 */
	@Override
	public List<Customer> viewCustomerList() {
		List<Customer>  list= customerDao.findAll();
		if(list.isEmpty())
			  throw new CustomerException("Customers list is empty");
		return list;
	}

	

}
