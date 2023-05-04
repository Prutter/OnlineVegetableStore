package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer customerId;
	@NotEmpty(message="Name is mandatory")
    private String name;
	@Size(min=10,max = 10,message = "Mobile number should be of 10 digits")
    private String mobileNumber;
    
    @Email(message = "Email address should be in a valid form")
    private String emailId;
    
    @Size(min=6,max=10,message = "Password length must be between 6 and 10")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    
    @NotEmpty(message = "Password confirmation is mandatory")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String confirmPassword;
    
    @Embedded
    private Address address;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="customerId")
    private Cart  cart;
}
