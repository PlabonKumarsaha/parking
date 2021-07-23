package com.pks.parking.Controller;


import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Repository.PrimaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/api/parking/primary/")
public class PrimaryUserController {

    @Autowired
    PrimaryUserRepository primaryUserRepository;
    @PostMapping("/check")
    public String checkController(){
        return "in primary controller";
    }

    @PostMapping("/addPrimaryUser")
    public PrimaryUser addPrimaryUser(@RequestBody PrimaryUser primaryUser) throws SQLException {
        System.out.println(primaryUser.getLatitude());
        System.out.println(primaryUser.getLongitude());
        System.out.println(primaryUser.getCurrentBalance());
        System.out.println(primaryUser.getPassword());
        System.out.println(primaryUser.getBkashPhoneNumberPU());
        System.out.println(primaryUser.getPu_Id());
        return primaryUserRepository.save(primaryUser);
    }

    @GetMapping("/getPrimaryUser/{id}")
    public Optional<PrimaryUser> getPrimaryUser(@PathVariable("id") Long id){
        Optional<PrimaryUser> primaryUser = primaryUserRepository.findById(id);
        return primaryUser;
    }

    // update emp rest API
    @PutMapping("/updatePrimaryUser/{id}")
    public PrimaryUser updatePrimaryUserById(@PathVariable Long id,@RequestBody PrimaryUser newPrimaryUser){
        PrimaryUser user = primaryUserRepository.findById(id).get();
       // user.get().setBkashPhoneNumberPU(newPrimaryUser.getBkashPhoneNumberPU());
        user.setName(newPrimaryUser.getName());
        user.setPassword(newPrimaryUser.getPassword());
        user.setLatitude(newPrimaryUser.getLatitude());
        user.setLongitude(newPrimaryUser.getLongitude());
        user.setCurrentBalance(newPrimaryUser.getCurrentBalance());
        return primaryUserRepository.save(user);
    }

    @DeleteMapping("/delPrimaryUser/{id}")
    public void deletePrimaryUser(@PathVariable("id") Long id){
        primaryUserRepository.deleteById(id);
    }


}
