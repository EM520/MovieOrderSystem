package com.elena.casestudy.movieordersystem.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users",uniqueConstraints =@UniqueConstraint(columnNames="email"))
@ToString(onlyExplicitlyIncluded = true)
//Create User Entity and table

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ToString.Include
	@EqualsAndHashCode.Include 
    private Long id;
	@Column(nullable = false)
	@ToString.Include
	@EqualsAndHashCode.Include 
	private String name;
	
	@Column(nullable = false, unique = true)
	@ToString.Include
	@EqualsAndHashCode.Include 
    private String email;
	
	@Column(nullable = false)
    private String password;
//	@LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(cascade = CascadeType.ALL, mappedBy="user",orphanRemoval = true)
//    private Set<Order> orders = new HashSet<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")}
			)
	private List<Role> roles = new ArrayList<>();
	//Create a User constructor with args
	public User(String email,String password) {
		super();
		this.email=email;
		this.password=password;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password);
	}
	
	
}
