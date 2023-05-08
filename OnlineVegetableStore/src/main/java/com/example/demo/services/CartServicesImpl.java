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
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.CustomerDao;
import com.example.demo.repositories.VegetableRepository;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	private CartRepository cartrepository;
	
	@Autowired
	private VegetableRepository vegetablerepo;

	@Override
	public Cart addToCart(Integer vid, Integer cid) {
		Optional<Vegetable> veg = vegetablerepo.findById(vid);
		if(veg== null)
			throw new VegetableException("vegetable with this id not exist");
		Vegetable vegetable = veg.get();
	
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		
		System.out.println(cart);
		System.out.println(vegetable);
		boolean flag = false;
		List<Vegetable> mylist = cart.getListOfVegetables();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).equals(vegetable)) {
				mylist.get(i).setQuantity(mylist.get(i).getQuantity()+1);
				flag = true;
			}
		}
		if(flag == false)
		cart.getListOfVegetables().add(vegetable);
		cartrepository.save(cart);
		return cart;
	}

	@Override
	public Cart IncreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid) {
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		List<Vegetable> mylist = cart.getListOfVegetables();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).getVegId()== vegetableId) {
				mylist.get(i).setQuantity(mylist.get(i).getQuantity()+ quantity);
				return cart;
			}
		}
		throw new VegetableException("Vegetable with this id does not exist");
	}

	@Override
	public Cart DecreaseVegetableQuantity(Integer vegetableId, Integer quantity, Integer cid) {
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		List<Vegetable> mylist = cart.getListOfVegetables();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).getVegId()== vegetableId){
				mylist.get(i).setQuantity(mylist.get(i).getQuantity() - quantity);
				return cart;
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
		
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		for(Vegetable v : cart.getListOfVegetables()) {
			if(v== vegetable) {
				cart.getListOfVegetables().remove(v);
				return cart;
			}
		}
		throw new VegetableException("Vegetable not added in the cart");
	}

	@Override
	public Cart RemoveAllVegetables(Integer cid) {
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		for(Vegetable v : cart.getListOfVegetables()) {
			cart.getListOfVegetables().remove(v);
		}
		return cart;
	}

	@Override
	public List<Vegetable> viewAllVegetables(Integer cid) {
		Optional<Cart> opt = cartrepository.findById(cid);
		if(opt==null)
			throw new CustomerException("Cart with this id does not exist");
		Cart cart = opt.get();
		return cart.getListOfVegetables();
	}
	
}
