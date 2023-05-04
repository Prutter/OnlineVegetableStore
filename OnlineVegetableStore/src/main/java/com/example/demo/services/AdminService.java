package com.example.demo.services;

import com.example.demo.entities.Admin;

public interface AdminService {
  public Admin addAdmin(Admin admin);
  public Admin updateAdmin(Admin admin);
  public Admin removeAdmin(Admin admin);
  public Admin viewAdmin(Admin admin);
}
