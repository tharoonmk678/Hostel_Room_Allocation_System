package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Room;
import com.examly.springapp.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController{
    @Autowired
    private RoomService service;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room saved = service.save(room);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Long id,
            @RequestBody Room room) {
        return ResponseEntity.ok(service.update(id, room));
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getRoomsByCategory(
            @PathVariable String categoryName) {
        return ResponseEntity.ok(service.getByCategoryName(categoryName));
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<?> getRoomsByNumber(@PathVariable String roomNumber) {
        List<Room> rooms = service.getByRoomNumber(roomNumber);
        if (rooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No room found with number: " + roomNumber);
        }
        return ResponseEntity.ok(rooms);
    }
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        service.deleteRoom(id);
    }


}
