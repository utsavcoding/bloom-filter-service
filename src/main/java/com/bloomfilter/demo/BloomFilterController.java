package com.bloomfilter.demo;

import com.bloomfilter.demo.data.AppUser;
import com.bloomfilter.demo.dto.CreateAppUserRequest;
import com.bloomfilter.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloom")
public class BloomFilterController {

    @Autowired
    private BloomFilter bloomFilter;
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/add")
    public ResponseEntity<String> createAppUser(
            @RequestBody CreateAppUserRequest createAppUserRequest
            ){
        if(bloomFilter.isAMember(createAppUserRequest.getUsername()))
            return ResponseEntity.badRequest().body("username is already taken \n"+bloomFilter.displayBloomFilter());


        //TODO What if bloom filter is filled with 1s, false positives will increase
        appUserService.createAppUser(createAppUserRequest);
        bloomFilter.add(createAppUserRequest.getUsername());
        return ResponseEntity.ok("User has been onboarded\n"+bloomFilter.displayBloomFilter());
    }
}
