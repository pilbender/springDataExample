package net.raescott.springdataexample.repository.jpa;

import net.raescott.springdataexample.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonRepositoryGenerated extends PagingAndSortingRepository<Person, String> {
	public List<Person> findAll();
	public Person findByName(String name);
}
