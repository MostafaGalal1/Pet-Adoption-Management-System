package com.adoptapet.adoptapet.Services.EntityServices;
import com.adoptapet.adoptapet.Dtos.SignUpDto;
import com.adoptapet.adoptapet.Dtos.StaffDto;
import com.adoptapet.adoptapet.Entities.Staff.Staff;
import com.adoptapet.adoptapet.Exceptions.ShelterExceptions.ShelterNotFoundException;
import com.adoptapet.adoptapet.Exceptions.StaffExceptions.StaffAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.StaffExceptions.StaffNotFoundException;
import com.adoptapet.adoptapet.Mappers.StaffMapper;
import com.adoptapet.adoptapet.Repositories.StaffRepository;
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

    public List<StaffDto> getAllStaffs() {
        return staffMapper.toDtoList(staffRepository.findAll());
    }

    public List<StaffDto> getAllStaffByShelterId(int shelterId) {
        if (staffRepository.findAllByShelterId(shelterId).isEmpty())
            throw new ShelterNotFoundException();
        return staffMapper.toDtoList(staffRepository.findAllByShelterId(shelterId));
    }

    public Staff getStaff(int staffId) {
        if (staffRepository.findById(staffId).isEmpty())
            throw new StaffNotFoundException();
        return staffRepository.findById(staffId).get();
    }

    public void addStaff(StaffDto staffDto) {
        if (staffRepository.findById(staffDto.getId()).isPresent())
            throw new StaffAlreadyExistsException();
        Staff staff = staffMapper.toEntity(staffDto);
        staffRepository.save(staff);
    }

    public void addStaff(SignUpDto signUpDto) {
        Staff staff = staffMapper.toEntity(signUpDto);
        staff.setId(staff.getAccount().getId());
        System.out.println(staff);
        staffRepository.save(staff);
    }

    public void updateStaff(StaffDto staffDto) {
        if (staffRepository.findById(staffDto.getId()).isEmpty())
            throw new StaffNotFoundException();
        Staff staff = staffRepository.findById(staffDto.getId()).get();
        staffMapper.partialUpdate(staffDto, staff);
        staffRepository.save(staff);
    }

    public void deleteStaff(int staffId) {
        if (staffRepository.findById(staffId).isEmpty())
            throw new StaffNotFoundException();
        staffRepository.deleteById(staffId);
    }
}
