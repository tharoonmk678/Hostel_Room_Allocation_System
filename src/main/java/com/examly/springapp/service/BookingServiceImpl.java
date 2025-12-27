package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo repo;

    public BookingServiceImpl(BookingRepo repo) {
        this.repo = repo;
    }

    public Booking save(Booking booking) {
        return repo.save(booking);
    }

    public List<Booking> findAll() {
        return repo.findAll();
    }

    public Booking findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Booking update(Long id, Booking booking) {
        booking.setBookingId(id);
        return repo.save(booking);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
