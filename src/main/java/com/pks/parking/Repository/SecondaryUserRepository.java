package com.pks.parking.Repository;

import com.pks.parking.Model.SecondaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryUserRepository extends JpaRepository<SecondaryUser, Long> {
}
