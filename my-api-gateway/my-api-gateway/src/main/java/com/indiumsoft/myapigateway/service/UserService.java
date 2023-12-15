package com.indiumsoft.myapigateway.service;

import com.indiumsoft.myapigateway.entity.HkrUsersInfo;
import com.indiumsoft.myapigateway.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(HkrUsersInfo userInformation) {
        userInformation.setPassword(passwordEncoder.encode(userInformation.getPassword()));
        repository.save(userInformation);
        return "user added to system ";
    }
}
