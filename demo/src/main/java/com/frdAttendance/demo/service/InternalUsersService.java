package com.frdAttendance.demo.service;

import com.frdAttendance.demo.model.InternalUsers;
import com.frdAttendance.demo.model.SystemUsers;
import com.frdAttendance.demo.repository.InternalUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InternalUsersService {

    @Autowired
    private InternalUsersRepository internalUsersRepository;

    public ResponseEntity<InternalUsers> saveInternalUser(InternalUsers internalUser) {
        internalUser = internalUsersRepository.save(internalUser);

        if (internalUser.getUserId()==null){
            throw new RuntimeException("internal User id is null");
        }else{
            return ResponseEntity.ok(internalUser);
        }
    }

    public boolean login(String userId, String password) {
        Optional<InternalUsers> userOptional = internalUsersRepository.findByUserId(userId);
        if (userOptional.isPresent()) {
            InternalUsers user = userOptional.get();
            int userEmpId = user.getEmpId();
            System.out.println(userEmpId);

            // Check for invalid empId (-99 indicates systemUser was null)
            if (userEmpId == -99) {
                return false;
            }

            return user.getPassword().equals(password);
        }
        return false;
    }


    public List<InternalUsers> getAllInternalUsers() {
        return internalUsersRepository.findAll();
    }

    public Optional<InternalUsers> getUserById(String userId) {
        return internalUsersRepository.findByUserId(userId);
    }

    public long getInternalUsersCount() {
        return internalUsersRepository.count();
    }
}
