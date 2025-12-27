package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.RoomCategory;

public interface RoomCategoryService {

    RoomCategory save(RoomCategory category);

    List<RoomCategory> getAll();

    RoomCategory getById(Long id);

    RoomCategory update(Long id, RoomCategory category);
}

