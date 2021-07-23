package com.pks.parking.Controller;

import com.pks.parking.Model.BookingDetails;
import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Repository.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/booking/")
public class BookingDetailsController {
    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @PostMapping("/addBookingDetails")
    public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails){
        System.out.println(bookingDetails.getBookingId());
        System.out.println("get primary data "+bookingDetails.getPrimaryUser());
        System.out.println("get secondary data"+bookingDetails.getSecondaryUser());


        return bookingDetailsRepository.save(bookingDetails);
    }
}
