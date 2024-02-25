package com.bloomfilter.demo.dto;

import lombok.Data;

@Data
public class CreateAppUserRequest {
    private String username;
    private String firstName;
    private String lastName;
}
