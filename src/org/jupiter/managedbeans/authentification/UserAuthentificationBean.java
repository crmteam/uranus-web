package org.jupiter.managedbeans.authentification;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jupiter.beans.user.UserBeanLocal;
import org.jupiter.entities.Profile;
import org.jupiter.entities.User;

@ManagedBean(name = "userAuthentificationBean")
@SessionScoped
public class UserAuthentificationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserBeanLocal userBean;

	private User user;
	private Profile profile;

	private List<User> listUser;

	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String phone;

	/**
	 * user login
	 */

	// /Doing login
	public void doFindUser() throws IOException {

		listUser = userBean.findAllUsers();
		for (User us : listUser) {
			if (us.getPassword().equals(password)
					&& us.getLogin().equals(login)) {
				user = userBean.findByLoginPass(login, password);

				if (user.getProfile().getUserprofile() == "customer") {

					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("home.privet");

				} else if (user.getProfile().getUserprofile() == "admin") {

					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("home.admin");
				} else {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("home.manager");
				}
			}
		}

	}

	// /Create user
	public String doCreateUser() {
		// profile = userBean.;
		User client = new User();
		client.setFirstname(name);
		client.setSurname(surname);
		client.setLogin(login);
		client.setPassword(password);
		client.setPhone(phone);
		client.setEmail(email);
		client.setProfile(profile);

		userBean.addUser(client);

		return "/login.privet?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
