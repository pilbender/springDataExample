package net.raescott.springdataexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Criteria Query Example Project
 */
//@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BeanFactory beanFactory = applicationContext;
		PersonDao personDao = (PersonDao) beanFactory.getBean("personDao");

        logger.info("*** Insert Data ***");
		Person person = new Person("scott", 5);
		logger.info("Person: " + person);
		personDao.persist(person);
		logger.info("Person: " + person);

        logger.info("*** Named Query Results ***");
		List<Person> personList1 = personDao.findAllNamedQuery();
		logger.info("Person List: " + personList1);
		logger.info("Done.");

        logger.info("*** Criteria Query Results ***");
        List<Person> personList2 = personDao.findAllCriteriaQuery();
        logger.info("Person List: " + personList2);
        logger.info("Done.");
	}
}
