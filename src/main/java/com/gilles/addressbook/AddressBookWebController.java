package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookWebController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    public AddressBookWebController() {
    }

    @RequestMapping("/bookUI")
    public String displayBooks(Model model) {
        model.addAttribute("addressBookList", addressBookRepository.findAll());
        model.addAttribute("buddiesList", buddyInfoRepository.findAll());
        return "bookDisplay";
    }

    @GetMapping("/createBookUI")
    public String bookCreate(Model model) {
        model.addAttribute("newBook", addressBookRepository.findAll());
        return "bookCreation";
    }

    @PostMapping("/createBookUI")
    public String addNewAddressBook() {
        addressBookRepository.save(new AddressBook());
        return "redirect:/bookUI";
    }

    @GetMapping("/createBuddyUI")
    public String buddyForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "buddyCreateForm";
    }

    @PostMapping("/createBuddyUI")
    public String buddySubmit(@ModelAttribute BuddyInfo buddy, Model model) {
        model.addAttribute("buddy", buddy);
        buddyInfoRepository.save(buddy);
        return "redirect:/bookUI";
    }

    @GetMapping("/addBuddyToAddressBook")
    public String showAddBuddyToAddressBook(Model model) {
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        return "addBuddytoBook";
    }

    @PostMapping("/addBuddyToAddressBook")
    public String addBuddyToAddressBook(@RequestParam("buddyId") Integer buddyId, @RequestParam("addressBookId") Integer addressBookId) {
        BuddyInfo buddy = buddyInfoRepository.findById(buddyId).orElseThrow();
        AddressBook addressBook = addressBookRepository.findById(addressBookId).orElseThrow();
        addressBook.addBuddy(buddy);
        addressBookRepository.save(addressBook);
        return "redirect:/bookUI";
    }
}
