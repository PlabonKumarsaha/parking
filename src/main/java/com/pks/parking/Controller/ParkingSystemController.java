package com.pks.parking.Controller;

import com.pks.parking.Repository.BookingDetailsRepository;
import com.pks.parking.Repository.PrimaryUserRepository;
import com.pks.parking.Repository.SecondaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parking/")
public class ParkingSystemController {
    @Autowired
    BookingDetailsRepository bookingDetailsRepository;


}
