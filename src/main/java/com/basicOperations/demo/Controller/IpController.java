package com.basicOperations.demo.Controller;

import com.basicOperations.demo.Entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IpController {
    @PostMapping("/getop")
    public String printUser(@RequestBody UserEntity userEntity){

        return "UserName: "+userEntity.getUserName()+"\n Phone No : "+userEntity.getPhNo();
    }
}
