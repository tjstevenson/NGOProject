package com.summitworks.entity;

import java.util.HashSet;
import java.util.List;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotBlank(message = "Please enter your first name")
	@Size(min = 2,max=50)
	private String firstName;
	
	@NotBlank(message = "Please Enter your last name")
	@Size(min = 2,max=50)
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email is required")
	@Column(name = "email")
	@Email(message="{errors.invalid_email}")
	private String email;

	@Column(name = "userName")
	private String userName;
	
	@NotBlank(message = "Password is required")
	@Column(name = "password")
	private String password;
	
	@Column(name = "Active")
	private boolean active;
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name = "user_events",
			joinColumns = { @JoinColumn(name = "user_id")},
			inverseJoinColumns = { @JoinColumn(name = "event_id")}
			)
	private Set<Events> events = new HashSet<Events>();
	
	@ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
       name="user_role",
       joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
       inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles;
	
	
	public User (String firstName, String lastName, String email, String userName, String password, String role, boolean active) {
		super();
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public List<Role> getRoles()
    {
        return roles;
    }
    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", active=" + active
				+ ", events=" + events + "]";
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}
	
	

	
}
