package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Room;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomRepo;
import com.examly.springapp.repository.RoomCategoryRepo;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo repo;

    @Autowired
    private RoomCategoryRepo roomCategoryRepo;

    //CREATE ROOM (FIX APPLIED HERE)
    @Override
    public Room save(Room room) {

        // Fetch MANAGED RoomCategory from DB
        RoomCategory category = roomCategoryRepo
                .findById(room.getRoomCategory().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Room category not found"));

        // Attach managed entity
        room.setRoomCategory(category);

        return repo.save(room);
    }

    // ET ALL ROOMS
    @Override
    public List<Room> getAll() {
        return repo.findAll();
    }

    // GET ROOM BY ID
    @Override
    public Room getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));}

    @Override
    public Room update(Long id, Room room) {

        room.setRoomId(id);

        RoomCategory category = roomCategoryRepo
                .findById(room.getRoomCategory().getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Room category not found"));

        room.setRoomCategory(category);

        return repo.save(room);
    }

    // DELETE ROOM
    @Override
    public void deleteRoom(Long id) {
        repo.deleteById(id);
    }

    // GET ROOMS BY CATEGORY NAME
    @Override
    public List<Room> getByCategoryName(String name) {
        return repo.findByRoomCategory_CategoryName(name);
    }

    // GET ROOM BY NUMBER
    @Override
    public List<Room> getByRoomNumber(String roomNumber) {
        return repo.findByRoomNumber(roomNumber);
    }
}




































































// package com.examly.springapp.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.examly.springapp.model.Room;
// import com.examly.springapp.repository.RoomRepo;

// @Service
// public class RoomServiceImpl implements RoomService {

//     @Autowired
//     private RoomRepo repo;

//     @Override
//     public Room save(Room room) {
//         return repo.save(room);
//     }

//     @Override
//     public List<Room> getAll() {
//         return repo.findAll();
//     }

//     @Override
//     public Room getById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public Room update(Long id, Room room) {
//         room.setRoomId(id);
//         return repo.save(room);
//     }

//         @Override
//     public void deleteRoom(Long id) {
//         repo.deleteById(id);
//     }

//     @Override
//     public List<Room> getByCategoryName(String name) {
//         return repo.findByRoomCategory_CategoryName(name);
//     }

//     @Override
//     public List<Room> getByRoomNumber(String roomNumber) {
//         return repo.findByRoomNumber(roomNumber);
//     }
// }
