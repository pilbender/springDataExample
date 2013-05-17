package net.raescott.springdataexample;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity Bean.
 *
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Entity
@Table(name = "person")
@NamedQueries({
	// Person.findAll does not conform to proper naming so it does not override.
	@NamedQuery(name = "Person.findAll", query = "select p from Person p order by name"), // Never gets called, only the generated one is used.
	@NamedQuery(name = "Person.findById", query = "select p from Person p where p.id = :id"), // Only called because of the Repository Implementation
	/*
	 * Person.findByName is intentionally wrong to show that this does override by using the proper naming
	 */
	@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name != ?1") // Overrides the generated method
})
public class Person implements Serializable {

	@Id @GeneratedValue
	private String id;
	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
