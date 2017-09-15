package ru.ICLTask;

import java.io.Serializable;

public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String email;

	public Author(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;

		this.lastname = lastname;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
