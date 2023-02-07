package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuddyInfoController {
    @Autowired
    private BuddyInfoService buddyInfoService;

    @PostMapping("/buddies")
    public BuddyInfo saveBuddyInfo(
            @RequestBody BuddyInfo buddyInfo) {
        return buddyInfoService.saveBuddyInfo(buddyInfo);
    }

    @GetMapping("/buddies")
    public List<BuddyInfo> fetchAllBuddyInfo() {
        return buddyInfoService.fetchAllBuddyInfo();
    }

    @PutMapping("/buddies/{id}")
    public BuddyInfo updateBuddyInfo(@RequestBody BuddyInfo buddyInfo, @PathVariable("id") Integer buddyInfoId) {
        return buddyInfoService.updateBuddyInfo(buddyInfo, buddyInfoId);
    }

    @DeleteMapping("/buddies/{id}")
    public String deleteBuddyInfoById(@PathVariable("id") Integer buddyInfoId) {
        buddyInfoService.deleteBuddyInfoById(buddyInfoId);
        return "Deleted Successfully";
    }
}
