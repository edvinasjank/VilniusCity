package com.edvinas.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity(name = "PEOPLE")
@Table(name = "PEOPLE")
public class Person {
	@Id
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "birthYear")
	private String birthYear;
	
	@NotNull
	@Column(name = "birthCountry")
	private String birthCountry;
	
	@NotNull
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "familyPosition")
	private String familyPosition;
	
	@Column(name = "kids")
	private int kids;
	
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Column(name = "street")
	private String street;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFamilyPosition() {
		return familyPosition;
	}

	public void setFamilyPosition(String familyPosition) {
		this.familyPosition = familyPosition;
	}

	public int getKids() {
		return kids;
	}

	public void setKids(int kids) {
		this.kids = kids;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	

}
