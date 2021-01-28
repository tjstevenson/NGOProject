package com.summitworks.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events {
	
	// Creation of attributes 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="event_id")
	private int eventID; 
	
	private String eventName;
	private String eventDescription; 
	private String eventCategory;
	private Date startDate; 
	private Date endDate; 
	private Date startTime;  
	private Date endTime; 
	private String location; 
	private String eventImage;
	private String eventRegistration;
	private double adultTicketPrice; 
	private double childTicketPrice;
	//Constructor
	public Events(int eventID, String eventName, String eventDescription, String eventCategory, Date startDate,
			Date endDate, Date startTime, Date endTime, String location, String eventImage, String eventRegistration,
			double adultTicketPrice, double childTicketPrice) {
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventCategory = eventCategory;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.eventImage = eventImage;
		this.eventRegistration = eventRegistration;
		this.adultTicketPrice = adultTicketPrice;
		this.childTicketPrice = childTicketPrice;
	}

	public Events() {
	}
	// getter and setters
	
	@ManyToMany(mappedBy = "events")
	private Set<User> users = new HashSet<>();
	
	public Set<User> getUsers() {
		return users;
	}// end
	
	//Setter and Getter
	public int getEventID() {
		return eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public String getLocation() {
		return location;
	}
	public String getEventImage() {
		return eventImage;
	}
	public String getEventRegistration() {
		return eventRegistration;
	}
	public double getAdultTicketPrice() {
		return adultTicketPrice;
	}
	public double getChildTicketPrice() {
		return childTicketPrice;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public void setEventRegistration(String eventRegistration) {
		this.eventRegistration = eventRegistration;
	}
	public void setAdultTicketPrice(double adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	public void setChildTicketPrice(double childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}
	
	
		
}
