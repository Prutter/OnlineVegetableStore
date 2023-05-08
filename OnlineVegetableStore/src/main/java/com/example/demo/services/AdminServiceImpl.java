package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.exceptions.AdminException;
import com.example.demo.repositories.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {
    
	@Autowired
	private AdminDao adminDao;
	
	
	/**
	 * This method is used to add the details of Admin into the database
	 * @paramAdmin
	 * @exception AdminException: If details are already exits || If provided details are empty
	 * @return Admin
	 * @author Ankit Choubey
	 */
	@Override
	public Admin addAdmin(Admin admin) {
		Optional<Admin>  res= adminDao.findByEmail(admin.getEmail());
		if(res.isPresent())
			  throw new AdminException("Details are already exits ,Please try login ");
		else {
			Admin response=   adminDao.save(admin);    
			return response;
		}
	
	}

	@Override
	public Admin updateAdmin(Admin admin) {
	Optional<Admin> res= adminDao.findByUserName(admin.getUserName());
    Admin  adm	=res.orElseThrow(()-> new AdminException("Details are invalid so admin cannot be update "));
    
    if(!admin.getEmail().equals("")){
		adm.setEmail(admin.getEmail());
	}
    if(!admin.getPhone().equals(""))
	{
	    adm.setPhone(admin.getPhone());
	   
	}
   
    
    return  adminDao.save(adm);
		
	}

	@Override
	public Admin removeAdmin(Admin admin) {
	  Optional<Admin> res= adminDao.findById(admin.getUserId());
	  if(res==null)
		  throw new AdminException("Details are invalid so admin cannot be deleted");
	  Admin a = res.get();
	  adminDao.delete(a);
	  return a;
	}

	
	/**
	 * This method is used to get Admin details using either email or number or Name 
	 * @paramAdmin
	 * @exception AdminException : If provided Creadential are invalid || Details are empty
	 * @returnAdmin
	 * @author Ankit Choubey
	 */
	@Override
	public Admin viewAdmin(Admin admin) {
		
		if(!admin.getEmail().equals(""))
		{
			Admin ans = adminDao.findByEmail(admin.getEmail()).orElseThrow(()->new AdminException("Invalid Credential"));
			return ans;
		}
		else if(!admin.getPhone().equals(""))
		{
			Admin ans = adminDao.findByPhone(admin.getPhone()).orElseThrow(()->new AdminException("Invalid Credential"));
			return ans;
		}
		else if(!admin.getUserName().equals(""))
		{
		 Admin ans =adminDao.findByUserName(admin.getUserName()).orElseThrow(()->new AdminException("Invalid Credential"));
		return ans;
		}
		else {
			 throw new AdminException("Details are empty so Admin details cannot be found");
		}
	}

}
