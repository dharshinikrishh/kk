package com.travel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userdetails")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	private String fullName;
	private long phoneNo;
    private String email;
	private int flatNo;
	private String streetName;
	private String landMark;
	private String city;
	private String state;
	private String country;
    
    
	public Profile(String fullName, long phoneNo, String email, int flatNo, String streetName, String landMark,
			String city, String state, String country) {
		super();
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.flatNo = flatNo;
		this.streetName = streetName;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
	
}
