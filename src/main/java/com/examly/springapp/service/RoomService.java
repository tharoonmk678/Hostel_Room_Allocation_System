package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Room;

public interface RoomService {

    Room save(Room room);

    List<Room> getAll();

    Room getById(Long id);

    Room update(Long id, Room room);

    List<Room> getByCategoryName(String name);

    List<Room> getByRoomNumber(String roomNumber);
}
