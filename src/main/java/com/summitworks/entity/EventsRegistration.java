package com.summitworks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventsRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="registration_id")
	private int registrationID; 
	private int eventID;
	private int userID;
	private String userEmail;
	private String userFirstName;
	
	public int getRegistrationID() {
		return registrationID;
	}
	public int getEventID() {
		return eventID;
	}
	public int getUserID() {
		return userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public EventsRegistration() {

	}
	public EventsRegistration(int registrationID, int eventID, int userID, String userEmail) {
		this.registrationID = registrationID;
		this.eventID = eventID;
		this.userID = userID;
		this.userEmail = userEmail;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	

}
