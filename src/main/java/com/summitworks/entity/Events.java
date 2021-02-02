package com.summitworks.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="events")
public class Events {
	
	// Creation of attributes 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="event_id")
	private int eventID; 
	@NotBlank
	@Size(min = 5,max=50)
	private String eventName;
	@NotBlank
	private String eventDescription; 
	@NotBlank
	private String eventCategory;
	@Future
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  
	private LocalDateTime startDate;
	@Future
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime endDate; 
	@NotNull
	@Size(min = 5, message = "Event location should have at least 5 characters")
	private String location; 
	private String eventImage;
	private boolean eventRegistration;
	@Min(value=5)
	@Max(value=25)
	private double adultTicketPrice; 
	@Min(value=2)
	@Max(value=10)
	private double childTicketPrice;
	//Constructor
	public Events(int eventID, String eventName, String eventDescription, String eventCategory, LocalDateTime startDate,
			LocalDateTime endDate, String location, String eventImage, boolean eventRegistration,
			double adultTicketPrice, double childTicketPrice) {
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventCategory = eventCategory;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.eventImage = eventImage;
		this.eventRegistration = eventRegistration;
		this.adultTicketPrice = adultTicketPrice;
		this.childTicketPrice = childTicketPrice;
	}

	public Events() {
	}
	// getter and setters
		
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
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public String getLocation() {
		return location;
	}
	public String getEventImage() {
		return eventImage;
	}
	public boolean getEventRegistration() {
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
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public void setEventRegistration(boolean eventRegistration) {
		this.eventRegistration = eventRegistration;
	}
	public void setAdultTicketPrice(double adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	public void setChildTicketPrice(double childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}
	
	
		
}
