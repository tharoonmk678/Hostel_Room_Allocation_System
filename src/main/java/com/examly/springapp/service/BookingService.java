package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Booking;

public interface BookingService {

    Booking save(Booking booking);

    List<Booking> findAll();

    Booking findById(Long id);

    Booking update(Long id, Booking booking);

    void delete(Long id);
}
