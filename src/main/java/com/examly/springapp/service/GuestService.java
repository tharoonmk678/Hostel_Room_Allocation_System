package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Guest;

public interface GuestService {

    Guest save(Guest guest);

    List<Guest> getAll();

    Guest getById(Long id);

    Guest update(Long id, Guest guest);

    List<Guest> getByPhone(String phone);

    List<Guest> getByEmail(String email);
    
    void delete(Long id);
}
