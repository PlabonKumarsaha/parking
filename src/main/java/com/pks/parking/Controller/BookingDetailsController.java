package com.pks.parking.Controller;

import com.pks.parking.Model.BookingDetails;
import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Model.SecondaryUser;
import com.pks.parking.Repository.BookingDetailsRepository;
import com.pks.parking.Repository.PrimaryUserRepository;
import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/booking/")
public class BookingDetailsController {
    private final BookingDetailsRepository bookingDetailsRepository;
    private final PrimaryUserRepository primaryUserRepository;
    private final SecondaryUserRepository secondaryUserRepository;

    public BookingDetailsController(BookingDetailsRepository bookingDetailsRepository, PrimaryUserRepository primaryUserRepository, SecondaryUserRepository secondaryUserRepository) {
        this.bookingDetailsRepository = bookingDetailsRepository;
        this.primaryUserRepository = primaryUserRepository;
        this.secondaryUserRepository = secondaryUserRepository;
    }

    @PostMapping("/addBookingDetails")
    public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails){
       // System.out.println(bookingDetails.getBookingId());
        System.out.println("get primary data "+bookingDetails.getPrimaryUser());
        System.out.println("get secondary data"+bookingDetails.getSecondaryUser());
        PrimaryUser primaryUser = primaryUserRepository.findById(bookingDetails.getPrimaryUser().getPuId()).orElse(null);
        SecondaryUser secondaryUser = secondaryUserRepository.findById(bookingDetails.getSecondaryUser().getSuId()).orElse(null);
        if(primaryUser != null){
            bookingDetails.setPrimaryUser(primaryUser);
        }
        if(secondaryUser != null){
            bookingDetails.setSecondaryUser(secondaryUser);
        }
        return bookingDetailsRepository.save(bookingDetails);
    }
}
