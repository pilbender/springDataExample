package net.raescott.springdataexample.repository.mongo;

import net.raescott.springdataexample.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonMongoRepositoryGenerated extends CrudRepository<Person, String> {
	// findAll can't be here because it is not a property to generate a method.
	//public Iterable<Person> findAll(String id);
	public Person findById(Integer id);
	public Iterable<Person> findByName(String name);
	public Iterable<Person> findByAge(int age);
}
