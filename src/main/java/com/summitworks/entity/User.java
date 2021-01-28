package com.summitworks.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	 
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "user_events",
			joinColumns = { @JoinColumn(name = "user_id")},
			inverseJoinColumns = { @JoinColumn(name = "event_id")}
			)
	private Set<Events> events = new HashSet<Events>();
	
	
	public User (String firstName, String lastName, String email,String password, String role) {
		super();
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(){}

	public Set<Events> getEvents() {
		return events;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", events=" + events + "]";
	}
	
	

	
}
