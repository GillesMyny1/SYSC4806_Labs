/**
 * Gilles Myny
 */
package com.gilles.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Lab5GillesMynyApplicationTests {
    @Value(value="${local.server.port}")
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getPlainBuddiesJSON() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/buddies", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getPlainAddressBooksJSON() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/addressbooks", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getPlainBuddyInfo() {
        BuddyInfo buddy = restTemplate.getForObject("http://localhost:" + port + "/buddies/1", BuddyInfo.class);
        Assertions.assertNotNull(buddy.getName());
        Assertions.assertEquals(buddy.getId(), 1);
    }

    @Test
    void getPlainAddressBook() {
        AddressBook aBook = restTemplate.getForObject("http://localhost:" + port + "/addressbooks/1", AddressBook.class);
        Assertions.assertNotNull((aBook.getBuddyList()));
        Assertions.assertEquals(aBook.getId(), 1);
    }

    @Test
    void testBuddyInfoHttpHeader() {
        HttpHeaders httpBuddyHeaders = restTemplate.headForHeaders("http://localhost:" + port + "/buddies");
        Assertions.assertTrue(httpBuddyHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAddressInfoHttpHeader() {
        HttpHeaders httpAddressHeaders = restTemplate.headForHeaders("http://localhost:" + port + "/addressbooks");
        Assertions.assertTrue(httpAddressHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAddressBookPost() {
        HttpEntity<AddressBook> request = new HttpEntity<>(new AddressBook());
        AddressBook aBook = restTemplate.postForObject("http://localhost:" + port + "/addressbooks", request, AddressBook.class);
        Assertions.assertNotNull(aBook);
        Assertions.assertEquals(aBook.getId(), 2);
    }

    @Test
    void testBuddyInfoPost() {
        HttpEntity<BuddyInfo> request = new HttpEntity<>(new BuddyInfo("Gilles", "Ottawa", 767));
        BuddyInfo buddy = restTemplate.postForObject("http://localhost:" + port + "/buddies", request, BuddyInfo.class);
        Assertions.assertNotNull(buddy);
        Assertions.assertEquals(buddy.getId(), 3);
    }
}
