package com.basicOperations.demo.Repository;

import com.basicOperations.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);
}
