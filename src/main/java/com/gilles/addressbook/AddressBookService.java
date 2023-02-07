package com.gilles.addressbook;

import java.util.List;

public interface AddressBookService {
    AddressBook saveAddressBook(AddressBook addressBook);

    List<AddressBook> fetchAddressBookList();

    void addToAddressBook(Integer buddyInfoId, Integer addressBookId);

    void deleteAddressBookById(Integer addressBookId);
}
