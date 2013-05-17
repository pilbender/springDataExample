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
		List<Person> personList1 = personDao.findAllNamedQuery();
		logger.info("Person List: " + personList1);
		logger.info("Done.");

        logger.info("*** Criteria Query Results ***");
        List<Person> personList2 = personDao.findAllCriteriaQuery();
        logger.info("Person List: " + personList2);
        logger.info("Done.");

		logger.info("*** Generated Repository Query Results ***");
		Person person3 = personRepositoryGenerated.findByName("scott");
		logger.info("Person 3: " + person3);
		logger.info("Done.");

		logger.info("*** Override Repository Query Results ***");
		Person person4 = personRepositoryOverride.findById("1");
		logger.info("Person 4: " + person4);
		logger.info("Done.");

		logger.info("*** Override Repository with @NamedQuery Results ***");
		Person person5 = personRepositoryGenerated.findByName("richard");
		logger.info("Person 5: " + person5);
		logger.info("Done.");
	}
}
