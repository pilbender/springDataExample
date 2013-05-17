package net.raescott.springdataexample.repository;

import net.raescott.springdataexample.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {
	public Person findByName(String name);
}
