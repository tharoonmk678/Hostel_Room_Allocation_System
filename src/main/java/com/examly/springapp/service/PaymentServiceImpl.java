// package com.examly.springapp.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.Payment;
// import com.examly.springapp.repository.PaymentRepo;

// @Service
// public class PaymentServiceImpl implements PaymentService {

//     private final PaymentRepo repo;

//     public PaymentServiceImpl(PaymentRepo repo) {
//         this.repo = repo;
//     }

//     public Payment save(Payment payment) {
//         return repo.save(payment);
//     }

//     public List<Payment> findAll() {
//         return repo.findAll();
//     }

//     public Payment findById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     public Payment update(Long id, Payment payment) {
//         payment.setPaymentId(id);
//         return repo.save(payment);
//     }

//     public void delete(Long id) {
//         repo.deleteById(id);
//     }
// }



package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.BookingRepo;
import com.examly.springapp.repository.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo repo;
    private final BookingRepo bookingRepo;

    @Autowired
    public PaymentServiceImpl(PaymentRepo repo, BookingRepo bookingRepo) {
        this.repo = repo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Payment save(Payment payment) {
        Booking booking = bookingRepo
                .findById(payment.getBooking().getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        payment.setBooking(booking);
        return repo.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return repo.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Payment update(Long id, Payment payment) {
        payment.setPaymentId(id);

        Booking booking = bookingRepo
                .findById(payment.getBooking().getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        payment.setBooking(booking);
        return repo.save(payment);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
