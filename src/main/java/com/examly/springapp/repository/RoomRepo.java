package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Room;

// @Repository
// public interface RoomRepo extends JpaRepository<Room, Long> {

//     List<Room> findByRoomNumber(String roomNumber);
//     //     @Query("SELECT r FROM Room r WHERE r.roomCategory.categoryName = :name")

//     // List<Room> findByRoomCategory_CategoryName(String categoryName);
//         @Query("SELECT r FROM Room r WHERE r.roomCategory.categoryName = :name")
//     List<Room> findRoomsByCategoryName(@Param("name") String name);
// }

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    List<Room> findByRoomNumber(String roomNumber);

    List<Room> findByRoomCategory_CategoryName(String categoryName);
}