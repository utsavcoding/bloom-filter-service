package com.bloomfilter.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloomFilterController {

    @GetMapping("/bloom/add")
    public String bloom(
            @RequestParam(value = "name",defaultValue = "World") String name
    ){

        return String.format("Bloom "+name);
    }
}
