package com.gilles.addressbook;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    AddressBook saveAddressBook(AddressBook addressBook);

    List<AddressBook> fetchAddressBookList();

    Optional<AddressBook> fetchAddressBookById(Integer addressBookId);

    void addToAddressBook(Integer buddyInfoId, Integer addressBookId);

    void deleteAddressBookById(Integer addressBookId);
}
