package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.repositories.CustomerDao;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	
	/**
	 * This method is used to add Customer details in database
	 * @paramCustomer 
	 * @return Customer
	 * @exception CustomerException
	 * @author Ankit choubey
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		Customer obCustomer= customerDao.findByEmailId(customer.getEmailId());
		    if(obCustomer!=null)
		    	  throw new CustomerException("Provided email id  is already exist so Please try with another email id");
		 obCustomer= customerDao.save(customer);
		return obCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		
			    
		return null;
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
		Customer res= customerDao.findByEmailId(customer.getEmailId());
		if(res==null)
			  throw new CustomerNotFoundException("Provided  customer details are invalid ,Please try again with correct details");
		
		 customerDao.delete(res);
		 return res;
		
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		
		return null;
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
