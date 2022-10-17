package com.elena.casestudy.movieordersystem.entity;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.elena.casestudy.movieordersystem.repository.RoleRepository;
import com.elena.casestudy.movieordersystem.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ColumnDefault("null")
	@Column(nullable = false,insertable = true, updatable = true)
	private Long id;
	@Column(length=30,nullable=false )
    
	private String name ;
	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<>();
	
    public Role(String name) {
    		super();
    		this.name=name;
    }
    
//    public void writeToDatabase (EntityManager em,String name) {
//        em.getTransaction().begin();
//        Role mt = new Role();
//        mt.setName("ROLE_AMDIN");
//        mt.setName("ROLE_USER");
//        em.persist(mt);
//        em.getTransaction().commit();
//        em.clear();
//    }
//    @Transactional
//    
//    public void insertADMIN() {
//    
//    	@Autowired
//    	private RoleRepository roleRepository;
//     Role mt = new Role();
//      mt.setName("ROLE_AMDIN");
//      roleRepository.save(mt);
//    }
	
}

