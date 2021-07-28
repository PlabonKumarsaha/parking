package com.pks.parking;

import com.pks.parking.Model.BookingDetails;
import com.pks.parking.Repository.BookingDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ParkingApplicationTests {

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	@Test
	void contextLoads() {
//		List<BookingDetails>getRes= bookingDetailsRepository.findBySecondaryUserDetailsBy(2L);
		//System.out.println(getRes.get(0));
	}

}
