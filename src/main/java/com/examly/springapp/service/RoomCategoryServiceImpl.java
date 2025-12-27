
package com.examly.springapp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryRepo repo;

    @Override
    public RoomCategory save(RoomCategory category) {
        return repo.save(category);
    }

    @Override
    public List<RoomCategory> getAll() {
        return repo.findAll();
    }

    @Override
    public RoomCategory getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RoomCategory update(Long id, RoomCategory category) {
        category.setCategoryId(id);
        return repo.save(category);
    }
}
