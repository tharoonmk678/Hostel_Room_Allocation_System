package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Payment;

public interface PaymentService {

    Payment save(Payment payment);

    List<Payment> findAll();

    Payment findById(Long id);

    Payment update(Long id, Payment payment);

    void delete(Long id);
}
