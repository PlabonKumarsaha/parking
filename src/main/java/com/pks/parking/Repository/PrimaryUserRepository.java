package com.pks.parking.Repository;

import com.pks.parking.Model.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Long> {
    PrimaryUser findByBkashPhoneNumberPU(String number);

    @Query(value = "SELECT * FROM parking.primary_user where primary_user.bkash_phone_numberpu =?1 and primary_user.password =?2",
    nativeQuery = true)
    PrimaryUser loginPrimary(@Param("phoneNum") String phoneNum,@Param("password") String password);

}
