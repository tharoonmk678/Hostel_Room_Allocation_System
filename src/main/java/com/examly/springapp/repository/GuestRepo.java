package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Guest;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Long> {

    List<Guest> findByPhone(String phone);

    List<Guest> findByEmail(String email);
}
