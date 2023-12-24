package com.adoptapet.adoptapet.Services;

import com.adoptapet.adoptapet.Entities.Staff.Staff;
import com.adoptapet.adoptapet.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff get(Integer id) {
        return staffRepository.findById(id).orElse(null);
    }

    public void add(Staff staff) {
        staffRepository.save(staff);
    }

    public void update(Staff staff) {
        staffRepository.save(staff);
    }

    public void delete(Staff staff) {
        staffRepository.delete(staff);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }

    public long count() {
        return staffRepository.count();
    }
}
