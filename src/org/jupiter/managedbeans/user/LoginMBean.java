package org.jupiter.managedbeans.user;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jupiter.beans.user.UserBeanLocal;
import org.jupiter.entities.User;

@ManagedBean(name = "loginMBean")
@SessionScoped
public class LoginMBean {

	@EJB
	private UserBeanLocal userBean;

	private User user;

	private String login;
	private String password;

	String messge;
	boolean connected;
	String nav;

	public LoginMBean() {
		user = new User();
	}
/**
 * login
 * @return
 */
	public String login() {

		messge = "";
		connected = false;
		nav = null;

		user = userBean.authentificate(login, password);
		if (null != user) {
			if (user.getProfile().equals("Admin")) {
				connected = true;
				nav = "/views/admin/dashbord?faces-redirect=true";
			} else if (user.getProfile().equals("Manager")) {
				connected = true;
				nav = "/views/manager/dashbord?faces-redirect=true";
			} else {
				connected = true;
				nav = "/views/customer/dashbord?faces-redirect=true";
			}
		} else {
			messge = "Erreur d'authentification";
		}
		return nav;
	}
	
	/**
	 * logout
	 * @return
	 */

	public String deconnexion(){
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		return "/wiews/login?faces-redirect=true";
		
	}
	public UserBeanLocal getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBeanLocal userBean) {
		this.userBean = userBean;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

}
