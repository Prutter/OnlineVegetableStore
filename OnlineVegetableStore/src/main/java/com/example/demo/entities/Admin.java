package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ADMIN")
@Data
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer adminId;
@NotBlank
@NotEmpty(message = "Admin Name field cannot be empty")
private String name;

@Size(min=10,max=10 ,message = "Number length should be 10")
private String contactNumber;

@Email(message = "Valid email address is required")
private String emailId;


}
