package com.basicOperations.demo.Controller;

import com.basicOperations.demo.Entity.UserEntity;
import com.basicOperations.demo.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> printUser(@RequestBody UserEntity userEntity){

        return ResponseEntity.ok("UserName: "+userEntity.getUserName()+"\n Phone No : "+userEntity.getPhNo());
    }

//    This is another style to write response Entity if we dont know the data type it is going to return
    @GetMapping("/allUsers")
    public ResponseEntity<?> getAll(){
        List<UserEntity>users = userService.getAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/getbyUn/{userName}")
    public ResponseEntity <UserEntity> getByUn(@PathVariable String userName){
        return ResponseEntity.ok(userService.findByUserName(userName).orElseThrow(()-> new RuntimeException("User Not Found!")));
    }
    @PostMapping("/create-user")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }
//  Response entity using try-catch exception handling to send proper http response
    @GetMapping("/getElegible")
    public ResponseEntity<?>getEle(){
        try {
            List<UserEntity> eligible = userService.getAllEle();
            return new ResponseEntity<>(eligible,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No Eligible user found",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getUser/{id}")
    public UserEntity getById(@PathVariable Long id){
        UserEntity userEntity = userService.getById(id).orElseThrow(() -> new RuntimeException("User not found" + id));
        return userEntity;
    }
}
