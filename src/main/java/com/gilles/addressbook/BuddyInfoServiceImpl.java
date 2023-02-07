package com.gilles.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BuddyInfoServiceImpl implements BuddyInfoService {
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Override
    public BuddyInfo saveBuddyInfo(BuddyInfo buddyInfo) {
        return buddyInfoRepository.save(buddyInfo);
    }

    @Override
    public List<BuddyInfo> fetchAllBuddyInfo() {
        return (List<BuddyInfo>) buddyInfoRepository.findAll();
    }

    @Override
    public Optional<BuddyInfo> fetchBuddyInfoById(Integer buddyInfoId) {
        return buddyInfoRepository.findById(buddyInfoId);
    }

    @Override
    public BuddyInfo updateBuddyInfo(BuddyInfo buddyInfo, Integer buddyInfoId) {
        BuddyInfo buInfo = buddyInfoRepository.findById(buddyInfoId).get();

        if(Objects.nonNull(buddyInfo.getName()) && !"".equalsIgnoreCase(buddyInfo.getName())) {
            buInfo.setName(buddyInfo.getName());
        }

        if(Objects.nonNull(buddyInfo.getAddress()) && !"".equalsIgnoreCase(buddyInfo.getAddress())) {
            buInfo.setAddress(buddyInfo.getAddress());
        }

        if(Objects.nonNull(buddyInfo.getPhoneNumber())) {
            buInfo.setPhoneNumber(buddyInfo.getPhoneNumber());
        }

        return buddyInfoRepository.save(buInfo);
    }

    @Override
    public void deleteBuddyInfoById(Integer buddyInfoId) {
        buddyInfoRepository.deleteById(buddyInfoId);
    }
}
