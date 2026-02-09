package com.basicOperations.demo.Controller;

import com.basicOperations.demo.Entity.UserEntity;
import com.basicOperations.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IpController {


//    @Autowired
//    private Repo repo;
//    Controller should not have the access of the repository so do not autowire repo in controller

//    Injecting dependency manually (Constructor Injection)
//    Note : The modifier should be private for security purposes
//    the constructer should be of the class which we are injecting the dependency
//    the param should be the object of the class we want to call
    private final UserService userService;

    public IpController(UserService userService){
        this.userService = userService;
    }
// Injecting dependencies using springboot feature
//    @Autowired
//    private UserService userService;

    @PostMapping("/getop")
    public String printUser(@RequestBody UserEntity userEntity){

        return "UserName: "+userEntity.getUserName()+"\n Phone No : "+userEntity.getPhNo();
    }

    @GetMapping("/allUsers") public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getbyUn/{userName}") public UserEntity getByUn(@PathVariable String userName){
        return userService.findByUserName(userName).orElseThrow(()-> new RuntimeException("User Not Found!"));
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
