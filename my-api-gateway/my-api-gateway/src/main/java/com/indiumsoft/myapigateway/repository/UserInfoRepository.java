package com.indiumsoft.myapigateway.repository;


import com.indiumsoft.myapigateway.entity.HkrUsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<HkrUsersInfo, Integer> {
    Optional<HkrUsersInfo> findByName(String username);

}