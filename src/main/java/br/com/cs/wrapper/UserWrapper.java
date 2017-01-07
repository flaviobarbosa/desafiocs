package br.com.cs.wrapper;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.cs.model.User;

@JsonInclude(content=Include.NON_EMPTY)
public class UserWrapper {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private Date created;
	
	private Date modified;
	
	private Date last_login;
	
	private String token;

	public UserWrapper(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.created = user.getCreated();
		this.modified = user.getModified();
		this.last_login = user.getLastLogin();
		this.token = user.getToken();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

