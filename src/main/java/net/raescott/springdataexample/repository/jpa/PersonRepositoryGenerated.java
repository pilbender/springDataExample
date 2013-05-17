package net.raescott.springdataexample.repository.jpa;

import net.raescott.springdataexample.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonRepositoryGenerated extends PagingAndSortingRepository<Person, String> {
	public List<Person> findAll();

	/**
	 * This is overridden by the Person Entity @NamedQuery.  That @NamedQuery is intentionally
	 * wrong.  Comment it out to test what Spring Data generates from this to see the difference.
	 * @param name
	 * @return
	 */
	public Person findByName(String name);

	/**
	 * Again, this @Query is intentionally wrong to illustrate that the generated one
	 * is overridden.  Comment this @Query out to see what Spring Data will do (correctly).
	 * @param age
	 * @return
	 */
	@Query("select p from Person p where age != ?1")
	public Person findByAge(int age);
}
