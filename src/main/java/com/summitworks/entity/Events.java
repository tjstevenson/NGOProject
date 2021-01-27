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
	private int EventID; 
	@Column(name="event_name")
	private String Event_Name;
	@Column(name="event_description")
	private String Event_Description; 
	@Column(name="event_category")
	private String Event_Category;
	@Column(name="event_start_date")
	private Date Start_Date; 
	@Column(name="event_end_time")
	private Date End_Date; 
	@Column(name="event_start_time")
	private Date Start_time;  
	@Column(name="event_end_time")
	private Date End_time; 
	@Column(name="event_location")
	private String Location; 
	@Column(name="event_allow_registration")
	private boolean Allow_registration;
	@Column(name="event_image")
	private String Event_Image;
	@Column(name="event_adult_ticket_price")
	private double Adult_Ticket_Price; 
	@Column(name="event_child_ticket_price")
	private double Child_Ticket_Price;
	//Constructor
	public Events(int eventID, String event_Name, String event_Description, String event_Category, Date start_Date,
			Date end_Date, Date start_time, Date end_time, String location, boolean allow_registration,
			String event_Image, double adult_Ticket_Price, double child_Ticket_Price) {
		EventID = eventID;
		Event_Name = event_Name;
		Event_Description = event_Description;
		Event_Category = event_Category;
		Start_Date = start_Date;
		End_Date = end_Date;
		Start_time = start_time;
		End_time = end_time;
		Location = location;
		Allow_registration = allow_registration;
		Event_Image = event_Image;
		Adult_Ticket_Price = adult_Ticket_Price;
		Child_Ticket_Price = child_Ticket_Price;
	}
	//Setter and Getter
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	public String getEvent_Name() {
		return Event_Name;
	}
	public void setEvent_Name(String event_Name) {
		Event_Name = event_Name;
	}
	public String getEvent_Description() {
		return Event_Description;
	}
	public void setEvent_Description(String event_Description) {
		Event_Description = event_Description;
	}
	public String getEvent_Category() {
		return Event_Category;
	}
	public void setEvent_Category(String event_Category) {
		Event_Category = event_Category;
	}
	public Date getStart_Date() {
		return Start_Date;
	}
	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}
	public Date getEnd_Date() {
		return End_Date;
	}
	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}
	public Date getStart_time() {
		return Start_time;
	}
	public void setStart_time(Date start_time) {
		Start_time = start_time;
	}
	public Date getEnd_time() {
		return End_time;
	}
	public void setEnd_time(Date end_time) {
		End_time = end_time;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public boolean isAllow_registration() {
		return Allow_registration;
	}
	public void setAllow_registration(boolean allow_registration) {
		Allow_registration = allow_registration;
	}
	public String getEvent_Image() {
		return Event_Image;
	}
	public void setEvent_Image(String event_Image) {
		Event_Image = event_Image;
	}
	public double getAdult_Ticket_Price() {
		return Adult_Ticket_Price;
	}
	public void setAdult_Ticket_Price(double adult_Ticket_Price) {
		Adult_Ticket_Price = adult_Ticket_Price;
	}
	public double getChild_Ticket_Price() {
		return Child_Ticket_Price;
	}
	public void setChild_Ticket_Price(double child_Ticket_Price) {
		Child_Ticket_Price = child_Ticket_Price;
	}
	@Override
	public String toString() {
		return "Events [EventID=" + EventID + ", Event_Name=" + Event_Name + ", Event_Description=" + Event_Description
				+ ", Event_Category=" + Event_Category + ", Start_Date=" + Start_Date + ", End_Date=" + End_Date
				+ ", Start_time=" + Start_time + ", End_time=" + End_time + ", Location=" + Location
				+ ", Allow_registration=" + Allow_registration + ", Event_Image=" + Event_Image
				+ ", Adult_Ticket_Price=" + Adult_Ticket_Price + ", Child_Ticket_Price=" + Child_Ticket_Price + "]";
	}
	
}
