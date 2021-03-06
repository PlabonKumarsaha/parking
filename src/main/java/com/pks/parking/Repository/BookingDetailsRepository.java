package com.pks.parking.Repository;

import com.pks.parking.Model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Long> {


    @Query(
            value = "SELECT * FROM parking.booking_details details WHERE details.secondary_user_su_id = ?1",
            nativeQuery = true
    )
    public List<BookingDetails>findBySecondaryUserDetailsByID(@Param("secondaryUserId") Long secondaryUserId);

//    @Query(
//            value = "SELECT details FROM BookingDetails details WHERE details.secondary_user_su_id.su_id = ?1"
//    )
//    public List<BookingDetails>findBySecondaryUserDetailsBy(@Param("secondaryUserId") Long secondaryUserId);

    @Query(
            value = "SELECT * FROM parking.booking_details details WHERE details.primary_user_pu_id = ?1",
            nativeQuery = true
    )
    public List<BookingDetails>findByPrimaryUserDetailsByID(@Param("primaryUserId") Long primaryUserId);

    @Query(
            value = "SELECT * FROM parking.booking_details WHERE primary_user_pu_id =?1 AND booking_id = ?2 ",
            nativeQuery = true
    )
    public BookingDetails findDetailsByBookingIDAndPrimaryId(@Param("primaryUserId") Long primaryUserId ,
                                                             @Param("bookingId") Long bookingId);

    @Query(
            value = "SELECT * FROM parking.booking_details WHERE secondary_user_su_id =?1 AND booking_id = ?2 ",
            nativeQuery = true
    )
    public BookingDetails findDetailsByBookingIDAndSecondaryId(@Param("secondaryUserId") Long secondaryUserId ,
                                                             @Param("bookingId") Long bookingId);
}
