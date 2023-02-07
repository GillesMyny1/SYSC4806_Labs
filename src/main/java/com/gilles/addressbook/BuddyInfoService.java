package com.gilles.addressbook;

import java.util.List;

public interface BuddyInfoService {
    BuddyInfo saveBuddyInfo(BuddyInfo buddyInfo);

    List<BuddyInfo> fetchAllBuddyInfo();

    BuddyInfo updateBuddyInfo(BuddyInfo buddyInfo, Integer buddyInfoId);

    void deleteBuddyInfoById(Integer buddyInfoId);
}
