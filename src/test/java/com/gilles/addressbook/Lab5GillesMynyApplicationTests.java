package com.gilles.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Lab5GillesMynyApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    private String buddiesResourceUrl = "http://localhost:8080/buddies";
    private String addressBooksResourceUrl = "http://localhost:8080/addressbooks";


    @Test
    void getPlainBuddiesJSON() {
        ResponseEntity<String> response = restTemplate.getForEntity(buddiesResourceUrl, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getPlainAddressBooksJSON() {
        ResponseEntity<String> response = restTemplate.getForEntity(addressBooksResourceUrl, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getPlainBuddyInfo() {
        BuddyInfo buddy = restTemplate.getForObject(buddiesResourceUrl + "/1", BuddyInfo.class);
        Assertions.assertNotNull(buddy.getName());
        Assertions.assertEquals(buddy.getId(), 1);
    }

    @Test
    void getPlainAddressBook() {
        AddressBook aBook = restTemplate.getForObject(addressBooksResourceUrl + "/1", AddressBook.class);
        Assertions.assertNotNull((aBook.getBuddyList()));
        Assertions.assertEquals(aBook.getId(), 1);
    }

    @Test
    void testBuddyInfoHttpHeader() {
        HttpHeaders httpBuddyHeaders = restTemplate.headForHeaders(buddiesResourceUrl);
        Assertions.assertTrue(httpBuddyHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAddressInfoHttpHeader() {
        HttpHeaders httpAddressHeaders = restTemplate.headForHeaders(addressBooksResourceUrl);
        Assertions.assertTrue(httpAddressHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAddressBookPost() {
        HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook());
        AddressBook aBook = restTemplate.postForObject(addressBooksResourceUrl, request, AddressBook.class);
        Assertions.assertNotNull(aBook);
        Assertions.assertEquals(aBook.getId(), 2);
    }

    @Test
    void testBuddyInfoPost() {
        HttpEntity<BuddyInfo> request = new HttpEntity<>(new BuddyInfo("Gilles", "Ottawa", 767));
        BuddyInfo buddy = restTemplate.postForObject(buddiesResourceUrl, request, BuddyInfo.class);
        Assertions.assertNotNull(buddy);
        Assertions.assertEquals(buddy.getId(), 3);
    }
}
