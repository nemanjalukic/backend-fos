package com.nl.fos.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nl.fos.vo.request.SignUpRequest;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@JsonIgnore 
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 16)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
    
    @JsonIgnore 
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 45)
    private String address;

    @Column(nullable = false, length = 45)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User() {
	}
    
    public User(SignUpRequest signUpRequest) {
    	this.username=signUpRequest.getUsername();
    	this.password=signUpRequest.getPassword();
    	this.address=signUpRequest.getAddress();
    	this.phone=signUpRequest.getPhone();
    	this.email=signUpRequest.getEmail();
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



}
