package com.gilles.addressbook;

import java.util.List;
import java.util.Optional;

public interface BuddyInfoService {
    BuddyInfo saveBuddyInfo(BuddyInfo buddyInfo);

    List<BuddyInfo> fetchAllBuddyInfo();

    Optional<BuddyInfo> fetchBuddyInfoById(Integer buddyInfoId);

    BuddyInfo updateBuddyInfo(BuddyInfo buddyInfo, Integer buddyInfoId);

    void deleteBuddyInfoById(Integer buddyInfoId);
}
