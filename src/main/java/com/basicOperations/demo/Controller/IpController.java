package com.basicOperations.demo.Controller;

import com.basicOperations.demo.Entity.UserEntity;
import com.basicOperations.demo.Repository.Repo;
import com.basicOperations.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IpController {


    @Autowired
    private Repo repo;

    @Autowired
    private UserService userService;

    @PostMapping("/getop")
    public String printUser(@RequestBody UserEntity userEntity){

        return "UserName: "+userEntity.getUserName()+"\n Phone No : "+userEntity.getPhNo();
    }

    @GetMapping("/allUsers") public List<UserEntity> getAll(){
        return userService.getAll();
    }
    @PostMapping("/create-user")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @GetMapping("/getElegible")public List<UserEntity>getEle(){
        return userService.getAllEle();
    }

    @GetMapping("/getUser/{id}") public UserEntity getById(@PathVariable Long id){
        return userService.getById(id).orElseThrow(()->new RuntimeException("User not found"+id));
    }
}
