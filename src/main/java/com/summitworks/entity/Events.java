package com.summitworks.entity;

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
	@DateTimeFormat(pattern="yyy-mm-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyy-mm-dd")
	private Date endDate; 
	@NotBlank
	private int startTime; 
	@NotBlank
	private int endTime; 
	@NotNull
	@Size(min = 5, message = "Event location should have at least 5 characters")
	private String location; 
	private String eventImage;
	
	@AssertTrue
	private boolean eventRegistration;
	@Min(value=5)
	@Max(value=25)
	private double adultTicketPrice; 
	@Min(value=2)
	@Max(value=10)
	private double childTicketPrice;
	//Constructor
	public Events(int eventID, String eventName, String eventDescription, String eventCategory, Date startDate,
			Date endDate, @NotBlank int startTime, @NotBlank int endTime, String location, String eventImage, @AssertTrue boolean eventRegistration,
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
	public @NotBlank int getStartTime() {
		return startTime;
	}
	public @NotBlank int getEndTime() {
		return endTime;
	}
	public String getLocation() {
		return location;
	}
	public String getEventImage() {
		return eventImage;
	}
	public @AssertTrue boolean getEventRegistration() {
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
	public void setStartTime(@NotBlank int startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(@NotBlank int endTime) {
		this.endTime = endTime;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public void setEventRegistration(@AssertTrue boolean eventRegistration) {
		this.eventRegistration = eventRegistration;
	}
	public void setAdultTicketPrice(double adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	public void setChildTicketPrice(double childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}
	
	
		
}
