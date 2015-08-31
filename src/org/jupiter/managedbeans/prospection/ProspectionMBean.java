package org.jupiter.managedbeans.prospection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jupiter.beans.prospection.ProspectionBeanLocal;
import org.jupiter.entities.Address;
import org.jupiter.entities.Company;
import org.jupiter.entities.Prospection;
import org.jupiter.entities.ProspectionStatus;
import org.jupiter.entities.User;

@ManagedBean(name="prospectionMBean")
@SessionScoped
public class ProspectionMBean implements Serializable {
	private static final long serialVersionUID = 1L;


	private List<Prospection>listProspection = new ArrayList<Prospection>();
	//  entities that we need in prospection
	private User customer;
	private Company company;
	private Prospection prospection;
	private Address address;
	private ProspectionStatus prospectionStatus;
	
	//customer
	private String email;
	private String login;
	private String firstname;
	private String lastname;
	private String password;
	private String phone;
	private String surname;
	
	
	// company
	private String companyName;
	private String companyPhone;
	private String website;
	private String sector;
	private String companyDescription;
	
	// address
	private int street;
	private String companyAddress;
	private String zipcode;
	private String contry;
	private String city;
	private String departement;
	
	// prosepection
	private String prospectionComment;
	
	// prospectStatus
	private String statusName;
	private String statusComment;
	
	
	@EJB
	private ProspectionBeanLocal prospectionBean;


	public ProspectionMBean() {
		customer = new User();
		company = new Company();
		prospectionStatus = new ProspectionStatus();
		address =  new Address();
		prospection = new Prospection();
	}
	
	/**
	 *  create a prospection
	 * @return
	 */
	
	public String addProspection(){
		 String result="failled";
		 
		// set a customer informations
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setLogin(login);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setPassword(password);
		
		
		
		// set company informations
		company.setCompanyName(companyName);
		company.setDescription(companyDescription);
		company.setSector(sector);
		company.setWebsite(website);
		
		//set address informations
		address.setStreet(street);
		address.setAddress(companyAddress);
		address.setCity(city);
		address.setDepartement(departement);
		address.setContry(contry);
		
		// set prospectionStatus informations
		prospectionStatus.setStatusName(statusName);
		prospectionStatus.setStatusComment(statusComment);
		
		
		// set prospection informations
		prospection.setAddress(address);
		prospection.setComment(prospectionComment);
		prospection.setCompany(company);
		prospection.setCustomer(customer);
		prospection.setProspectionStatus(prospectionStatus);
		
		if(null != address|| null != company  || null != customer  || null != prospectionStatus){
			prospectionBean.addPropection(prospection);
			
			result ="success";
		}
		
		return "result";
	}
	
	/**	 
	 * metho- get all prosepections
	 */
	public List<Prospection> findAllProspection(){		
		listProspection = prospectionBean.findAllProspections();
		return listProspection;
	}

	/**
	 * method- remove prospection
	 * 
	 */
	
	public String removeProspection(Object o){
		if((Prospection)o != null){
			
		}
		return "success";
	}
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Prospection getProspection() {
		return prospection;
	}

	public void setProspection(Prospection prospection) {
		this.prospection = prospection;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ProspectionStatus getProspectionStatus() {
		return prospectionStatus;
	}

	public void setProspectionStatus(ProspectionStatus prospectionStatus) {
		this.prospectionStatus = prospectionStatus;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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

	public String getProspectionComment() {
		return prospectionComment;
	}

	public void setProspectionComment(String prospectionComment) {
		this.prospectionComment = prospectionComment;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusComment() {
		return statusComment;
	}

	public void setStatusComment(String statusComment) {
		this.statusComment = statusComment;
	}

	public ProspectionBeanLocal getProspectionBean() {
		return prospectionBean;
	}

	public void setProspectionBean(ProspectionBeanLocal prospectionBean) {
		this.prospectionBean = prospectionBean;
	}
	
	
	

}
