package net.raescott.springdataexample;

import net.raescott.springdataexample.repository.PersonRepositoryOverride;
import net.raescott.springdataexample.repository.jpa.PersonRepositoryGenerated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Spring Data Example Project
 */
//@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BeanFactory beanFactory = applicationContext;
		PersonDao personDao = (PersonDao) beanFactory.getBean("personDao");
		PersonRepositoryGenerated personRepositoryGenerated = (PersonRepositoryGenerated) beanFactory.getBean("personRepositoryGenerated");
		PersonRepositoryOverride personRepositoryOverride = (PersonRepositoryOverride) beanFactory.getBean("personRepositoryOverride");

        logger.info("*** Insert Data ***");
		Person person1 = new Person("scott", 5);
		logger.info("Person 1: " + person1);
		personDao.persist(person1);
		logger.info("Person 1: " + person1);
		Person person2 = new Person("richard", 6);
		logger.info("Person 2: " + person2);
		personDao.persist(person2);
		logger.info("Person 2: " + person2);

        logger.info("*** Named Query Results ***");
		logger.info("Expect: [richard, scott]");
		logger.info("Shows the @NamedQuery is called because order is reversed");
		logger.info("personDao.findAllNamedQuery()");
		List<Person> personList1 = personDao.findAllNamedQuery();
		logger.info("Person List 1: " + personList1);
		logger.info("Done.");

        logger.info("*** Criteria Query Results ***");
		logger.info("Expect: [scott, richard]");
		logger.info("Shows the Criteria query is returning in the inserted order");
		logger.info("personDao.findAllCriteriaQuery()");
        List<Person> personList2 = personDao.findAllCriteriaQuery();
        logger.info("Person List 2: " + personList2);
        logger.info("Done.");

		logger.info("*** Override Repository Query Results ***");
		logger.info("Expect: [richard]");
		logger.info("Shows the generated query is overridden by the incorrect @NamedQuery");
		logger.info("personRepositoryGenerated.findByName(\"scott\")");
		Person person3 = personRepositoryGenerated.findByName("scott");
		logger.info("Person 3: " + person3);
		logger.info("Done.");

		logger.info("*** Override Repository Query Results ***");
		logger.info("Expect: [scott]");
		logger.info("Shows the interface and implementation override and call the @NamedQuery");
		logger.info("personRepositoryOverride.findById(\"1\")");
		Person person4 = personRepositoryOverride.findById("1");
		logger.info("Person 4: " + person4);
		logger.info("Done.");

		logger.info("*** Spring Data Generated Results ***");
		logger.info("Expect: [scott, richard]");
		logger.info("Shows the results of Spring Data generated query, the @NamedQuery is ignored");
		logger.info("personRepositoryGenerated.findAll()");
		List<Person> personList3 = personRepositoryGenerated.findAll();
		logger.info("Person List 3: " + personList3);
		logger.info("Done.");

		logger.info("*** Override with @Query Results ***");
		logger.info("Expect: [richard]");
		logger.info("Shows the generated query is overridden by the incorrect @Query");
		logger.info("personRepositoryGenerated.findByAge(5)");
		Person person5 = personRepositoryGenerated.findByAge(5);
		logger.info("Person 5: " + person5);
		logger.info("Done.");
	}
}
