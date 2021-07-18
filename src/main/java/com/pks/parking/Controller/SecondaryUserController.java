package com.pks.parking.Controller;


import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/secondary/")
public class SecondaryUserController {
    @Autowired
    SecondaryUserRepository secondaryUserRepository;
    
}
