package net.raescott.springdataexample.repository;

import net.raescott.springdataexample.Person;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Repository("personRepositoryOverride")
public class PersonRepositoryOverrideImpl implements PersonRepositoryOverride {
<<<<<<< HEAD
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	@PersistenceContext(unitName = "mysqlPersistenceUnit")
=======
	private static final Logger logger = LoggerFactory.getLogger(PersonRepositoryOverrideImpl.class);
	@PersistenceContext(unitName = "h2PersistenceUnit")
>>>>>>> 1784bf2... Fixed the Logger in PersonRepositoryOverrideImpl.
	EntityManager em;

	@Override
	@Transactional(value = "mysql")
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
