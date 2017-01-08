package br.com.cs.wrapper;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.cs.model.Phone;
import br.com.cs.model.User;

@JsonInclude(content=Include.NON_EMPTY)
public class UserWrapper {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String created;
	
	private String modified;
	
	private String last_login;
	
	private String token;
	
	private List<Phone> phones;

	public UserWrapper(User user, String token) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.token = token;
		this.phones = user.getPhones();
		
		DateTime lastLogin = new DateTime(user.getLastLogin());
		this.last_login = lastLogin.toString(DateTimeFormat.mediumDateTime());
		
		DateTime created = new DateTime(user.getCreated());
		this.created = created.toString(DateTimeFormat.mediumDateTime());
		
		DateTime modified = new DateTime(user.getModified());
		this.modified = modified.toString(DateTimeFormat.mediumDateTime());
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}

