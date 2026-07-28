package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("Application Started");

        displayCountry();

        displayCountries();
    }

    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("country", Country.class);

        Country anotherCountry =
                context.getBean("country", Country.class);

        LOGGER.debug("Country 1 : {}", country);

        LOGGER.debug("Country 2 : {}", anotherCountry);

        LOGGER.info("END");
    }

    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries =
                (List<Country>) context.getBean("countryList");

        countries.forEach(country ->
                LOGGER.debug(country.toString()));

        LOGGER.info("END");
    }
}