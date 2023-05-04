package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Admin;
import com.example.demo.exceptions.AdminException;
import com.example.demo.repositories.AdminDao;

public class AdminServiceImpl implements AdminService {
    
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin addAdmin(Admin admin) {
		Admin response=   adminDao.save(admin);    
		return response;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> res= adminDao.findByName(admin.getName());
    Admin  adm	=res.orElseThrow(()-> new AdminException("Details are invalid so admin cannot be update "));
    
    if(!admin.getEmailId().equals(""))
	{
		adm.setEmailId(admin.getEmailId());
		
	}
    if(!admin.getContactNumber().equals(""))
	{
	    adm.setContactNumber(admin.getContactNumber());
	   
	}
   
    
    return  adminDao.save(adm);
		
	}

	@Override
	public Admin removeAdmin(Admin admin) {
	  Admin res= adminDao.findById(admin.getAdminId()).orElseThrow(()->new AdminException("Details are invalid so admin cannot be deleted"));
		adminDao.delete(res);
		return res;
	}

	@Override
	public Admin viewAdmin(Admin admin) {
		
		if(!admin.getName().equals(""))
		{
		 Admin ans =adminDao.findByName(admin.getName()).orElseThrow(()->new AdminException("Invalid details"));
		return ans;
		}
		
		if(!admin.getEmailId().equals(""))
		{
			Admin ans = adminDao.findByEmailId(admin.getEmailId()).orElseThrow(()->new AdminException("Invalid details"));
			return ans;
		}
		
		if(!admin.getContactNumber().equals(""))
		{
			Admin ans = adminDao.findByContactNumber(admin.getContactNumber()).orElseThrow(()->new AdminException("Invalid details"));
			return ans;
		}
		else {
			 throw new AdminException("Details are empty so Admin details cannot be found");
		}
		
		
		
		
	}

}
