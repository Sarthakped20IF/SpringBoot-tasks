package com.basicOperations.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // This will create a table named User in Db
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String userName;
    private String phNo;



    private int age;

    public UserEntity() {

    }


    public int getAge() {
        return age;
    }
    public String getPhNo() {
        return phNo;
    }
    public void setPhNo(String phNo){
        this.phNo=phNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public void setAge(int age){
        this.age=age;
    }

    public UserEntity(String userName,String phNo,int age){
        this.userName=userName;
        this.phNo=phNo;
        this.age=age;
    }
}
