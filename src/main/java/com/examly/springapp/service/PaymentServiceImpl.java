package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo repo;

    public PaymentServiceImpl(PaymentRepo repo) {
        this.repo = repo;
    }

    public Payment save(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> findAll() {
        return repo.findAll();
    }

    public Payment findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Payment update(Long id, Payment payment) {
        payment.setPaymentId(id);
        return repo.save(payment);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
