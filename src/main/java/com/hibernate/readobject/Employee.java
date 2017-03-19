package com.hibernate.readobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Empoyees")
public class Employee {
	@Column(name="name")
	String first_name;
	@Column(name="city")
	String city;
	@Column(name="profession")
	String profession;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="emp_id")
	int employee_id;
	public Employee(String first_name, String city, String profession) {
		super();
		this.first_name = first_name;
		this.city = city;
		this.profession = profession;
	}
	
	public Employee() {
		super();
		
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", city=" + city + ", profession=" + profession + ", employee_id="
				+ employee_id + "]";
	}
	
	

}
