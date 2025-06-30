/**
 * Gilles Myny
 */
package com.gilles.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab5GillesMynyApplication {
    public static void main(String[] args) {
        SpringApplication.run(Lab5GillesMynyApplication.class, args);
    }
    public static final Logger log = LoggerFactory.getLogger(Lab5GillesMynyApplication.class);

    @Bean
    public CommandLineRunner demo(AddressBookRepository repositoryA) {
        return (args) -> {
            AddressBook ab = new AddressBook();
            ab.addBuddy(new BuddyInfo("Elliot", "Seattle", 343));
            ab.addBuddy(new BuddyInfo("David", "Vancouver", 767));

            repositoryA.save(ab);
            // get all buddies
            log.info("AddressBook found with findAll():");
            log.info("---------------------------------");
            Iterable<AddressBook> addressBooks = repositoryA.findAll();
            log.info("Printing all BuddyInfo's found in the AddressBook:");
            for(AddressBook a : addressBooks) {
                for(BuddyInfo buddy : a.getBuddyList()) {
                    log.info("ID: " + buddy.getId() + "\tName: " + buddy.getName() + "\tAddress: " + buddy.getAddress() + "\tNumber: " + buddy.getPhoneNumber());
                }
            }
            log.info("");
        };
    }
}
