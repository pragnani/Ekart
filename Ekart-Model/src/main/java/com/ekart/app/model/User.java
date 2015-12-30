package com.ekart.app.model;

import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.FetchMode;

@Entity
@Table(
uniqueConstraints = {
		@UniqueConstraint(columnNames = "username")})
public class User extends AbstractEntity implements IUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private Long userId;
	
	@Column(name="username")
	private String username;

	private String name;

	private String email;

	private String password;

	private boolean enabled;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "user")
	private List<Address> userAdress;

	@OneToOne
	private Cart cart;

	@ManyToMany
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="userid")}, inverseJoinColumns={@JoinColumn(name="roleid")})
	private List<Role> roles;

	public boolean isEnabled() {
		return enabled;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

	}

	public List<Address> getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(List<Address> userAdress) {
		this.userAdress = userAdress;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	




}
