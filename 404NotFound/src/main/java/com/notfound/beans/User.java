package com.notfound.beans;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userSequence")
	@SequenceGenerator(allocationSize = 1, name = "userSequence", sequenceName = "SQ_USER_PK")
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "ZIP")
	private int zip;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SHANE_BUCKS_ID")
	private ShaneBucks shaneBucks;
	
	
	public User() {
		super();
	}
	
	public User(int userId, String firstName, String lastName, String address, String city, String country, int zip, ShaneBucks shaneBucks) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.shaneBucks = shaneBucks;
	}
	
	public User(int userId, String firstName, String lastName, String address, String city, String country, int zip) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public ShaneBucks getShaneBucks() {
		return shaneBucks;
	}
	public void setShaneBucks(ShaneBucks shaneBucks) {
		this.shaneBucks = shaneBucks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", zip=" + zip + ", shaneBucks=" + shaneBucks + "]";
	}
	
	
	
	
	
}
