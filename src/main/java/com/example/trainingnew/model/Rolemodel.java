package com.example.trainingnew.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rolemodel {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private long id;
	private String role;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "roles")
	private Set<Usermodel> users = new HashSet<>();

	
//	public Rolepojo(long id) {
//		super();
//		this.id = id;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Set<UserPojo> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<UserPojo> users) {
//		this.users = users;
//	}
	
	
	
}
