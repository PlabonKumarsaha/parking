package com.pks.parking.Repository;

import com.pks.parking.Model.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, String> {
}
