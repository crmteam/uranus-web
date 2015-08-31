package org.jupiter.managedbeans.user;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.jupiter.beans.user.UserBeanLocal;
import org.jupiter.entities.Address;
import org.jupiter.entities.Profile;
import org.jupiter.entities.User;

@ManagedBean(name = "userMBean")
@RequestScoped
public class UserMBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserBeanLocal userBean;

	private User user;
	private Address userAddress;
	
	private List<User> users;

	private String email;
	private String login;
	private String firstname;
	private String lastname;
	private String password;
	private String phone;
	private String surname;

	private int street;
	private String address;
	private String zipcode;
	private String contry;
	private String city;
	private String departement;

	public UserMBean() {

		user = new User();
		userAddress = new Address();
	}

	public String addUser() {
		
		Profile profile = new Profile();
		profile.setUserProfile("customer");		
		
		userAddress.setStreet(street);
		userAddress.setCity(city);
		userAddress.setContry(contry);
		userAddress.setZipcode(zipcode);
		userAddress.setAddress(address);

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setLogin(login);
		user.setEmail(email);
		user.setPhone(phone);
		user.setProfile(profile);
		user.setAddress(userAddress);

		if (null != firstname || null != lastname) {

			userBean.addUser(user);

			FacesMessage message = new FacesMessage("Succès de l'inscription !");
			FacesContext.getCurrentInstance().addMessage(null, message);

		}

		return "succes";
	}
	
	public List<User> getAllUsers() {
		users = userBean.findAllUsers();
		return users;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
