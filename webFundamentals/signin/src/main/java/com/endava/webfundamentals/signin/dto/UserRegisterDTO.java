package com.endava.webfundamentals.signin.dto;

/**
 * Created by fstancu on 8/1/2016.
 */
public class UserRegisterDTO {

	private String username;
	private String password;
	private String repeatPassword;

	public UserRegisterDTO() {
		super();
	}

	public UserRegisterDTO(String username, String password, String repeatPassword) {
		super();
		this.username = username;
		this.password = password;
		this.repeatPassword = repeatPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	@Override
	public String toString() {
		return "UserRegisterDTO{" + "username='" + username + '\'' + ", password='" + password + '\''
				+ ", repeatPassword='" + repeatPassword + '\'' + '}';
	}
}
