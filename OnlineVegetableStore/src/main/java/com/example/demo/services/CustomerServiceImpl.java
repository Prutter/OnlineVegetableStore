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
		Customer obCustomer= customerDao.findByEmailId(customer.getEmailId()).orElseThrow(()->new CustomerException("Provided email id  is already exist so Please try with another email id"));
		   
		 obCustomer= customerDao.save(customer);
		return obCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Customer res= customerDao.findByEmailId(customer.getEmailId()).orElseThrow(()->new CustomerException("Customer details Not found"));
	   
	    
	    if(!customer.getEmailId().equals(""))
		{
			res.setEmailId(customer.getEmailId());
			
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
		Customer res= customerDao.findByEmailId(customer.getEmailId()).orElseThrow(()->new CustomerNotFoundException("Provided  customer details are invalid ,Please try again with correct details"));
		
		
		 customerDao.delete(res);
		 return res;
		
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		
		
		if(!customer.getEmailId().equals(""))
		{
			Customer ans = customerDao.findByEmailId(customer.getEmailId()).orElseThrow(()->new CustomerException("Invalid details"));
			return ans;
		}
		
		if(!customer.getMobileNumber().equals(""))
		{
			Customer ans = customerDao.findByMobileNumber(customer.getMobileNumber()).orElseThrow(()-> new CustomerException("Invalid details"));
			return ans;
		}
		else {
			 throw new AdminException("Details are empty so Admin details cannot be found");
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
