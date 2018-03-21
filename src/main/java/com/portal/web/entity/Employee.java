package com.portal.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.annotation.JsonView;
import com.portal.web.jsonview.Views;

import lombok.Data;

/**
 * @author Mike
 */
// tag::code[]
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
    @GeneratedValue(generator="EmployeeInvSeq",strategy=GenerationType.SEQUENCE) 
    @SequenceGenerator(name="EmployeeInvSeq",sequenceName="EmployeeInvSeq_INV_SEQ", allocationSize=5)	
	@Column(name = "id", length = 6, nullable = false,unique=true)
	@JsonView(Views.Public.class)
	private Long id;
	
    @Column(name = "firstName", length = 64, unique=true)
    @JsonView(Views.Public.class)
	private String firstName;
    
    @Column(name = "lastName", length = 64, unique=true)
    @JsonView(Views.Public.class)
	private String lastName;
    
    @Column(name = "description", length = 64, columnDefinition="VARCHAR(250)")
    @Type(type = "text")
    @JsonView(Views.Public.class)
	private String description;

	private Employee() {}

	public Employee(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
// end::code[]
