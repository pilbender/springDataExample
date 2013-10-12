package net.raescott.springdataexample.repository.mongo;

import net.raescott.springdataexample.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonMongoRepositoryGenerated extends CrudRepository<Person, String> {
	/*
	public Iterable<Person> findAll(String id);
	public Iterable<Person> findById(String id);
	public Iterable<Person> findByName(String name);
	public Iterable<Person> findByAge(String age);
	*/
}
