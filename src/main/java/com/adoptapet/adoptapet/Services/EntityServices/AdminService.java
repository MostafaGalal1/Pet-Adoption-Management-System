package com.adoptapet.adoptapet.Services.EntityServices;


import com.adoptapet.adoptapet.Dtos.AdminDto;
import com.adoptapet.adoptapet.Exceptions.AdminExceptions.AdminAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.AdminExceptions.AdminNotFoundException;
import com.adoptapet.adoptapet.Mappers.AdminMapper;
import com.adoptapet.adoptapet.Repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public List<AdminDto> getAllAdmins() {
        return adminMapper.toDtoList(adminRepository.findAll());
    }

    public AdminDto getAdmin(int adminId) {
        if (adminRepository.findById(adminId).isEmpty())
            throw new AdminNotFoundException();
        return adminMapper.toDto(adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found")));
    }

    public void addAdmin(AdminDto adminDto) {
        if (adminRepository.findById(adminDto.getId()).isPresent())
            throw new AdminAlreadyExistsException();
        adminRepository.save(adminMapper.toEntity(adminDto));
    }

    public void updateAdmin(AdminDto adminDto) {
        if (adminRepository.findById(adminDto.getId()).isEmpty())
            throw new AdminNotFoundException();
        adminRepository.save(adminMapper.toEntity(adminDto));
    }

    public void deleteAdmin(int adminId) {
        if (adminRepository.findById(adminId).isEmpty())
            throw new AdminNotFoundException();
        adminRepository.deleteById(adminId);
    }
}
