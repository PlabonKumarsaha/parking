package com.pks.parking.Repository;

import com.pks.parking.Model.PrimaryUser;
import com.pks.parking.Model.SecondaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryUserRepository extends JpaRepository<SecondaryUser, Long> {

    SecondaryUser findByBkashPhoneNumberSU(String number);

    @Query(value = "SELECT * FROM parking.secondary_user where secondary_user.bkash_phone_numbersu =?1 and secondary_user.password =?2",
            nativeQuery = true)
    SecondaryUser loginSecondary(@Param("phoneNum") String phoneNum, @Param("password") String password);

}
