package com.example.demo.entities;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.validation.constraints.NotEmpty;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer  extends User{
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Integer customerId;
	@NotEmpty(message="Name is mandatory")
    private String name;
   
    @Embedded
    private Address address;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="customerId")
    private Cart  cart;
}
