package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Vegetable;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.VegetableException;
import com.example.demo.repositories.CustomerDao;
import com.example.demo.repositories.VegetableRepository;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	private CustomerDao customerRepository;
	
	@Autowired
	private VegetableRepository vegetablerepo;

	@Override
	public Cart addToCart(Vegetable vegetable, Integer cid) {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		Cart customerCart = customer.getCart();
		
		customerCart.getListOfVegetables().add(vegetable);
		return customerCart;
	}

	@Override
	public Cart IncreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid) {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		
		Cart customerCart = customer.getCart();
		List<Vegetable> mylist = customerCart.getListOfVegetables();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).getVegId()== vegetableId) {
				mylist.get(i).setQuantity(mylist.get(i).getQuantity()+ quantity);
				return customerCart;
			}
		}
		throw new VegetableException("Vegetable with this id does not exist");
	}

	@Override
	public Cart DecreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid) {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		
		Cart customerCart = customer.getCart();
		List<Vegetable> mylist = customerCart.getListOfVegetables();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).getVegId()== vegetableId){
				mylist.get(i).setQuantity(mylist.get(i).getQuantity() - quantity);
				return customerCart;
			}
		}
		throw new VegetableException("Vegetable with this id does not exist");
	}

	@Override
	public Cart RemoveVegetable(Integer vegetableId, Integer cid) {
		Optional<Vegetable> vege = vegetablerepo.findById(vegetableId);
		if(vege==null)
			throw new VegetableException("vegetable does not exist");
		Vegetable vegetable= vege.get();
		
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		
		Cart customerCart = customer.getCart();
		for(Vegetable v : customerCart.getListOfVegetables()) {
			if(v== vegetable) {
				customerCart.getListOfVegetables().remove(v);
				return customerCart;
			}
		}
		throw new VegetableException("Vegetable not added in the cart");
	}

	@Override
	public Cart RemoveAllVegetables(Integer cid) {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		
		Cart customerCart = customer.getCart();
		for(Vegetable v : customerCart.getListOfVegetables()) {
			customerCart.getListOfVegetables().remove(v);
		}
		return customerCart;
	}

	@Override
	public List<Vegetable> viewAllVegetables(Integer cid) {
		Optional<Customer> opt = customerRepository.findByUserId(cid);
		if(opt==null)
			throw new CustomerException("Customer with this id does not exist");
		Customer customer = opt.get();
		
		Cart customerCart = customer.getCart();
		
		return customerCart.getListOfVegetables();
	}
	
}
