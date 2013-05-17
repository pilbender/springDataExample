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
	@NamedQuery(name = "Person.findAll", query = "select p from Person p order by name"),
	@NamedQuery(name = "Person.findById", query = "select p from Person p where p.id = :id"),
	@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name = ?1")
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
