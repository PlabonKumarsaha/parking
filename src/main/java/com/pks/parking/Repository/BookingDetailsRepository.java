package com.pks.parking.Repository;

import com.pks.parking.Model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Long> {


//    @Query("select details from BookingDetails details where details.bookingId=:primaryUserId")
    @Query(
            value = "SELECT * FROM parking.booking_details details WHERE details.secondary_user_su_id = ?1",
            nativeQuery = true
    )
    public List<BookingDetails>findBySecondaryUserDetailsByID(@Param("secondaryUserId") Long secondaryUserId);

    @Query(
            value = "SELECT * FROM parking.booking_details details WHERE details.primary_user_pu_id = ?1",
            nativeQuery = true
    )
    public List<BookingDetails>findByPrimaryUserDetailsByID(@Param("primaryUserId") Long primaryUserId);
}
