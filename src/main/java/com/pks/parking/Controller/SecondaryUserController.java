package com.pks.parking.Controller;


import com.pks.parking.Model.SecondaryUser;
import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parking/secondary/")
public class SecondaryUserController {
    @Autowired
    SecondaryUserRepository secondaryUserRepository;
    @PostMapping("/addSecondaryUser")
    public String addSecondaryUser(@RequestBody SecondaryUser secondaryUser){
        SecondaryUser getUserByPhoneNumber = secondaryUserRepository.findByBkashPhoneNumberSU(secondaryUser.getBkashPhoneNumberSU());
        if(getUserByPhoneNumber ==null){
            secondaryUserRepository.save(secondaryUser);
            return "Welcome to the system added";
        }else {
            return "already registered with the number";
        }
    }

    @GetMapping("/getSecondaryUser/{id}")
    public Optional<SecondaryUser> getSecondaryUser(@PathVariable("id") Long id){
        Optional<SecondaryUser> primaryUser = secondaryUserRepository.findById(id);
        return primaryUser;
    }

    @PutMapping("/updateSecondaryUser/{id}")
    public SecondaryUser updateSecondaryUserById(@PathVariable Long id,@RequestBody SecondaryUser newSecondaryUser){
        SecondaryUser user = secondaryUserRepository.findById(id).get();
        user.setName(newSecondaryUser.getName());
        user.setPassword(newSecondaryUser.getPassword());
        user.setLatitude(newSecondaryUser.getLatitude());
        user.setLongitude(newSecondaryUser.getLongitude());
        user.setCurrentBalance(newSecondaryUser.getCurrentBalance());
        user.setHourlyRentForBike(newSecondaryUser.getHourlyRentForBike());
        user.setNumberOfBikes(newSecondaryUser.getNumberOfBikes());
        user.setNumberOfCars(newSecondaryUser.getNumberOfCars());
        user.setHourlyRentForCar(newSecondaryUser.getHourlyRentForCar());
        user.setBankName(newSecondaryUser.getBankName());
        user.setAcNumber(newSecondaryUser.getAcNumber());
        return secondaryUserRepository.save(user);
    }

    @DeleteMapping("/delSecondaryUser/{id}")
    public void deleteSecondaryUser(@PathVariable("id") Long id){
        secondaryUserRepository.deleteById(id);
    }
}
