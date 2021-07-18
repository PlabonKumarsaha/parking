package com.pks.parking.Controller;


import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Repository.PrimaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parking/primary/")
public class PrimaryUserController {

    @Autowired
    PrimaryUserRepository primaryUserRepository;

    @PostMapping("/addPrimaryUser")
    public PrimaryUser addPrimaryUser(@RequestBody PrimaryUser primaryUser){
        return primaryUserRepository.save(primaryUser);
    }

    @GetMapping("/getPrimaryUser/{id}")
    public Optional<PrimaryUser> getPrimaryUser(@PathVariable("id") String id){
        Optional<PrimaryUser> primaryUser = primaryUserRepository.findById(id);
        return primaryUser;
    }

    // update emp rest API
    @PutMapping("/getPrimaryUser/{id}")
    public PrimaryUser updatePrimaryUserById(@PathVariable String id,@RequestBody PrimaryUser newPrimaryUser){
        PrimaryUser user = primaryUserRepository.findById(id).get();
       // user.get().setBkashPhoneNumberPU(newPrimaryUser.getBkashPhoneNumberPU());
        user.setName(newPrimaryUser.getName());
        user.setPassword(newPrimaryUser.getPassword());
        user.setLatitude(newPrimaryUser.getLatitude());
        user.setLongitude(newPrimaryUser.getLongitude());
        user.setCurrentBalance(newPrimaryUser.getCurrentBalance());
        return primaryUserRepository.save(user);
    }

    @DeleteMapping("/getPrimaryUser/{id}")
    public void deletePrimaryUser(@PathVariable("id") String id){
        primaryUserRepository.deleteById(id);
    }


}
