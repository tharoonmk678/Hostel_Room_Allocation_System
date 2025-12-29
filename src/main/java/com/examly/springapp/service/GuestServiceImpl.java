package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepo repo;

    @Override
    public Guest save(Guest guest) {
        return repo.save(guest);
    }

    @Override
    public List<Guest> getAll() {
        return repo.findAll();
    }

    @Override
    public Guest getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found"));
    }

    @Override
    public Guest update(Long id, Guest guest) {
        guest.setGuestId(id);
        return repo.save(guest);
    }

    @Override
    public List<Guest> getByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    @Override
    public List<Guest> getByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        Guest guest = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));

        repo.delete(guest);   // cascade will handle bookings & payments
    }
}
