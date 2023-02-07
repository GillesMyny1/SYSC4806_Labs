package com.gilles.addressbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Integer>, CrudRepository<BuddyInfo, Integer> {
}
