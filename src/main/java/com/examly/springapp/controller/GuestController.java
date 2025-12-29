package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestService service;

    // POST /api/guests
    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        Guest saved = service.save(guest);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/guests
    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(
            @PathVariable Long id,
            @RequestBody Guest guest) {
        return ResponseEntity.ok(service.update(id, guest));
    }


    
// @GetMapping("/phone/{phone}")
// public ResponseEntity<?> getGuestsByPhone(@PathVariable String phone) {

//     List<Guest> guests = service.getByPhone(phone);

//     if (guests.isEmpty()) {
//         return ResponseEntity
//                 .status(HttpStatus.NO_CONTENT)
//                 .body("No guest found with phone: " + phone);
//     }

//     return ResponseEntity.ok(guests);
// }

@GetMapping("/phone/{phone}")
public ResponseEntity<?> getGuestByPhone(@PathVariable String phone) {

    List<Guest> guests = service.getByPhone(phone);

    if (guests.isEmpty()) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No guest found with phone: " + phone);
    }

    return ResponseEntity.ok(guests);
}


    @GetMapping("/email/{email}")
    public ResponseEntity<List<Guest>> getGuestsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getByEmail(email));
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
}
}
