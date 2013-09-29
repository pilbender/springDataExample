package net.raescott.springdataexample.repository;

import net.raescott.springdataexample.App;
import net.raescott.springdataexample.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Repository("personRepositoryOverride")
public class PersonRepositoryOverrideImpl implements PersonRepositoryOverride {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	@PersistenceContext(unitName = "h2PersistenceUnit")
	EntityManager em;

	@Override
	@Transactional(value = "h2")
	public Person findById(Integer id) {
		Person person = new Person(); // Null Object Pattern
		try {
			person = (Person) em.createNamedQuery("Person.findById")
					.setParameter("id", id)
					.getSingleResult();
		} catch (NoResultException nre) {
			// This is okay, it means the database was empty.
		}
		return person;
	}
}
