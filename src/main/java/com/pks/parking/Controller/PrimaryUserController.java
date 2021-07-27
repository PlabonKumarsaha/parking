package com.pks.parking.Controller;


import com.pks.parking.Model.BookingDetails;
import com.pks.parking.Model.BookingDetailsContainer;
import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Repository.BookingDetailsRepository;
import com.pks.parking.Repository.PrimaryUserRepository;
import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/parking/primary/")
public class PrimaryUserController {

    @Autowired
    private  BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    private  PrimaryUserRepository primaryUserRepository;
    @Autowired
    private  SecondaryUserRepository secondaryUserRepository;
//    public PrimaryUserController(BookingDetailsRepository bookingDetailsRepository, PrimaryUserRepository primaryUserRepository, SecondaryUserRepository secondaryUserRepository) {
//        this.bookingDetailsRepository = bookingDetailsRepository;
//        this.primaryUserRepository = primaryUserRepository;
//        this.secondaryUserRepository = secondaryUserRepository;
//    }
    @PostMapping("/check")
    public String checkController(){
        return "in primary controller";
    }

    @PostMapping("/addPrimaryUser")
    public String addPrimaryUser(@RequestBody PrimaryUser primaryUser) throws SQLException {
        System.out.println(primaryUser.getLatitude());
        System.out.println(primaryUser.getLongitude());
        System.out.println(primaryUser.getCurrentBalance());
        System.out.println(primaryUser.getPassword());
        System.out.println(primaryUser.getBkashPhoneNumberPU());
        System.out.println(primaryUser.getPuId());
        PrimaryUser getUserByPhoneNumber = primaryUserRepository.findByBkashPhoneNumberPU(primaryUser.getBkashPhoneNumberPU());
        if(getUserByPhoneNumber ==null){
            primaryUserRepository.save(primaryUser);
            return "new user added";
        }else {
            return "already registered with the number";
        }
    }

    @GetMapping("/getPrimaryUser/{id}")
    public PrimaryUser getPrimaryUser(@PathVariable("id") Long id){
        PrimaryUser primaryUser = primaryUserRepository.findById(id).get();
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

    @GetMapping("/getAllBooked/{id}")
    public List<BookingDetailsContainer> getAllBooked(@PathVariable("id") Long id) {
        System.out.println("id"+id);
        List<BookingDetailsContainer>returnDetails = new ArrayList<>();
        List<BookingDetails> getALl = bookingDetailsRepository.findByPrimaryUserID(id);
        //System.out.println("details "+ getALl.get(0));
        for(int i =0 ;i< getALl.size(); i++) {
            BookingDetailsContainer bookingDetailsContainer = new BookingDetailsContainer();
            bookingDetailsContainer.setBookingId(getALl.get(i).getBookingId());
            bookingDetailsContainer.setDuration(getALl.get(i).getDuration());
            bookingDetailsContainer.setEndingTime(getALl.get(i).getEndingTime());
            bookingDetailsContainer.setStartingTime(getALl.get(i).getStartingTime());
            bookingDetailsContainer.setDuration(getALl.get(i).getDuration());
            bookingDetailsContainer.setVehicleType(getALl.get(i).getVehicleType());
            bookingDetailsContainer.setPaymentStatus(getALl.get(i).getPaymentStatus());
            returnDetails.add(bookingDetailsContainer);

        }

        System.out.println("booking details container"+ returnDetails.get(0));
        return returnDetails;
    }


}
