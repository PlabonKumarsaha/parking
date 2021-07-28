package com.pks.parking.Controller;


import com.pks.parking.Model.BookingDetails;
import com.pks.parking.Model.BookingDetailsContainer;
import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Model.SecondaryUser;
import com.pks.parking.Repository.BookingDetailsRepository;
import com.pks.parking.Repository.PrimaryUserRepository;
import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parking/secondary/")
public class SecondaryUserController {
    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    private PrimaryUserRepository primaryUserRepository;
    @Autowired
    private  SecondaryUserRepository secondaryUserRepository;

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

    @GetMapping("/getAllBooked/{id}")
    public List<BookingDetailsContainer> getAllBooked(@PathVariable("id") Long id) {
        System.out.println("id"+id);
        List<BookingDetailsContainer>returnDetails = new ArrayList<>();
        List<BookingDetails> getALl = bookingDetailsRepository.findBySecondaryUserDetailsByID(id);
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
            bookingDetailsContainer.setPrimaryUserPuId(getALl.get(i).getPrimaryUser().getPuId());
            bookingDetailsContainer.setSecondaryUserSuId(getALl.get(i).getSecondaryUser().getSuId());
            returnDetails.add(bookingDetailsContainer);
        }

        System.out.println("booking details container"+ returnDetails.get(0));
        return returnDetails;
    }


    @GetMapping("/getSecondaryUser/{id}/booking/{bid}")
    public BookingDetailsContainer getIndividualDetails(@PathVariable("id") Long id, @PathVariable("bid") Long bid ) {
        System.out.println("id"+id + "  "+"bid" +bid);
        BookingDetailsContainer returnDetails = new BookingDetailsContainer();
        BookingDetails bd = new BookingDetails();
        bd = bookingDetailsRepository.findDetailsByBookingIDAndSecondaryId(id,bid);
        System.out.println("bd"+bd);

        returnDetails.setBookingId(bd.getBookingId());
        returnDetails.setPaymentStatus(bd.getPaymentStatus());
        returnDetails.setDuration(bd.getDuration());
        returnDetails.setVehicleType(bd.getVehicleType());
        returnDetails.setStartingTime(bd.getStartingTime());
        returnDetails.setEndingTime(bd.getEndingTime());
        returnDetails.setPrimaryUserPuId(bd.getPrimaryUser().getPuId());
        returnDetails.setSecondaryUserSuId(bd.getSecondaryUser().getSuId());
        System.out.println(returnDetails);
        return returnDetails;
    }

    @GetMapping("/login/{phoneNo}/{password}")
    public SecondaryUser login(@PathVariable("phoneNo") String phoneNo, @PathVariable("password") String pass) {
        SecondaryUser user = secondaryUserRepository.loginSecondary(phoneNo, pass);
        return user;
    }



}
