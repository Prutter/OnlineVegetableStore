package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "ADMIN")
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin extends User {
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Integer adminId;
@NotBlank
@NotEmpty(message = "Admin Name field cannot be empty")
private String name;

@Embedded
private Address officeAddress;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="adminId")
private List<Vegetable> vegitablelist;


}
