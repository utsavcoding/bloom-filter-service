package com.bloomfilter.demo.service;

import com.bloomfilter.demo.data.AppUser;
import com.bloomfilter.demo.data.AppUserRepository;
import com.bloomfilter.demo.dto.CreateAppUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository=appUserRepository;
    }

    public void createAppUser(CreateAppUserRequest createAppUserRequest){
        AppUser appUser = new AppUser();
        appUser.setFirstName(createAppUserRequest.getFirstName());
        appUser.setUsername(createAppUserRequest.getUsername());
        appUser.setLastName(createAppUserRequest.getLastName());

        appUserRepository.save(appUser);
    }

}
