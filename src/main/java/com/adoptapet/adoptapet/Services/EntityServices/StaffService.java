package com.adoptapet.adoptapet.Services.EntityServices;
import com.adoptapet.adoptapet.Dtos.StaffDto;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import com.adoptapet.adoptapet.Mappers.StaffMapper;
import com.adoptapet.adoptapet.Repositories.StaffRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    private final StaffMapper staffMapper;

    @Autowired
    public StaffService(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    public List<StaffDto> getAllStaffs(int shelterId) {
        return staffMapper.toDtoList(staffRepository.findAllByShelterId(shelterId));
    }

    public Staff get(Integer id) {
        return staffRepository.findById(id).orElse(null);
    }

    public void add(StaffDto staffDto) {
        staffRepository.save(staffMapper.toEntity(staffDto));
    }

    public void update(StaffDto staffDto) {
        Staff staff = staffRepository.findById(staffDto.getId()).orElse(null);
        staffMapper.partialUpdate(staffDto, staff);
        staffRepository.save(staff);
    }

    public void delete(int staffId) {
        staffRepository.deleteById(staffId);
    }

    public void deleteAll() {
        staffRepository.deleteAll();
    }

    public long count() {
        return staffRepository.count();
    }

    public ResponseEntity<String > getStaff(StaffDto staffDto) {
        Staff staff = staffMapper.toEntity(staffDto);
        if (!staffRepository.existsByAccount(staff.getAccount())) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        staffRepository.save(staff);
        return new ResponseEntity<>( "Staff saved", HttpStatus.ACCEPTED );
    }
}
