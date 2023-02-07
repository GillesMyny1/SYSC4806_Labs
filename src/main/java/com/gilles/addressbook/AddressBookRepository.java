package com.gilles.addressbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Integer>, CrudRepository<AddressBook, Integer> {
}
