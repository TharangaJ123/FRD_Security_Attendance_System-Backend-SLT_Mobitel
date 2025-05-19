package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.CompanyUsers;
import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SecurityStaff;
import com.frdAttendance.demo.repository.CompanyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyUserService {

    @Autowired
    private CompanyUserRepository companyUserRepository;

    public ResponseEntity<CompanyUsers> saveCompanyUser(CompanyUsers companyUser) {
        companyUser = companyUserRepository.save(companyUser);

        if(companyUser.getId()==0){
            throw new RuntimeException("Company User id is null");
        }else{
            return ResponseEntity.ok(companyUser);
        }
    }

    public List<CompanyUsers> getAllCompanyUsers(){
        return companyUserRepository.findAll();
    }

    public boolean login(String userId, String password) {
        System.out.println(userId);
        Optional<CompanyUsers> userOptional = companyUserRepository.findByEmail(userId);
        if (userOptional.isPresent()) {
            CompanyUsers user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    public Optional<CompanyUsers> getUserByEmail(String userId) {
        return companyUserRepository.findByEmail(userId);
    }

}
