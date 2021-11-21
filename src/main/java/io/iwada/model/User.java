package io.iwada.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3584150858539695521L;

	@Id
	@Column(name = "user_id")
	private String user_id;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(
			name = "user_sector",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "sector_id"))
	Set<Sector> userSectorList;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public Set<Sector> getUserSectorList() {
		return userSectorList;
	}

	public void setUserSectorList(Set<Sector> userSectorList) {
		this.userSectorList = userSectorList;
	}
}
