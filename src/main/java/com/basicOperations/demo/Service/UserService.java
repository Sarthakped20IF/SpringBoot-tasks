package com.basicOperations.demo.Service;

import com.basicOperations.demo.Entity.UserEntity;
import com.basicOperations.demo.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private Repo repo;
    public List<UserEntity> getAll(){
        List<UserEntity> Users = repo.findAll();
        return Users;
    }
    
    public List<UserEntity> getAllEle(){
        List<UserEntity> all = repo.findAll().stream()
                .filter(user->user.getAge()>=18)
                .toList();
        return all;
    }

    public UserEntity createUser(UserEntity userEntity){
        UserEntity newUser = repo.save(userEntity);
        return newUser;
    }
    public Optional<UserEntity> getById(Long Id){
        UserEntity userId = repo.getById(Id);
        return Optional.of(userId);
    }
}
