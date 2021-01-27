package com.summitworks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Created by Cristian
@Entity
@Table(name="events")
public class Events {
	// Creation of attributes 
	@Id
	@Column(name="event_id")
	private int eventID; 
	@Column(name="event_name")
	private String eventName;
	@Column(name="event_description")
	private String eventDescription; 
	@Column(name="event_category")
	private String eventCategory;
	@Column(name="event_start_date")
	private Date startDate; 
	@Column(name="event_end_time")
	private Date endDate; 
	@Column(name="event_start_time")
	private Date startTime;  
	@Column(name="event_end_time")
	private Date endTime; 
	@Column(name="event_location")
	private String location; 
	@Column(name="event_allow_registration")
	private boolean allowRegistration;
	@Column(name="event_image")
	private String eventImage;
	@Column(name="event_adult_ticket_price")
	private double adultTicketPrice; 
	@Column(name="event_child_ticket_price")
	private double childTicketPrice;
	//Constructor
	public Events(int eventID, String eventName, String eventDescription, String eventCategory, Date startDate,
			Date endDate, Date startTime, Date endTime, String location, boolean allowRegistration, String eventImage,
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
		this.allowRegistration = allowRegistration;
		this.eventImage = eventImage;
		this.adultTicketPrice = adultTicketPrice;
		this.childTicketPrice = childTicketPrice;
	}
	//Setter and Getter
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAllowRegistration() {
		return allowRegistration;
	}
	public void setAllowRegistration(boolean allowRegistration) {
		this.allowRegistration = allowRegistration;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public double getAdultTicketPrice() {
		return adultTicketPrice;
	}
	public void setAdultTicketPrice(double adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	public double getChildTicketPrice() {
		return childTicketPrice;
	}
	public void setChildTicketPrice(double childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}
	@Override
	public String toString() {
		return "Events [eventID=" + eventID + ", eventName=" + eventName + ", eventDescription=" + eventDescription
				+ ", eventCategory=" + eventCategory + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location
				+ ", allowRegistration=" + allowRegistration + ", eventImage=" + eventImage + ", adultTicketPrice="
				+ adultTicketPrice + ", childTicketPrice=" + childTicketPrice + "]";
	}
		
}
