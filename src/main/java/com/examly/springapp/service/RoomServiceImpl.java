package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomRepo;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo repo;

    @Override
    public Room save(Room room) {
        return repo.save(room);
    }

    @Override
    public List<Room> getAll() {
        return repo.findAll();
    }

    @Override
    public Room getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Room update(Long id, Room room) {
        room.setRoomId(id);
        return repo.save(room);
    }

    @Override
    public List<Room> getByCategoryName(String name) {
        return repo.findByRoomCategory_CategoryName(name);
    }

    @Override
    public List<Room> getByRoomNumber(String roomNumber) {
        return repo.findByRoomNumber(roomNumber);
    }
}
