package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressBookWebController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookWebController() {
    }

    @RequestMapping("/bookUI")
    public String displayBooks(Model model) {
        model.addAttribute("buddyweb", addressBookRepository.findById(1).get().getBuddyList());
        return "buddyweb";
    }
}
