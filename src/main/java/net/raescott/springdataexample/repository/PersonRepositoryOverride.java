package net.raescott.springdataexample.repository;

import net.raescott.springdataexample.Person;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
public interface PersonRepositoryOverride {
	public Person findById(String id);
}
