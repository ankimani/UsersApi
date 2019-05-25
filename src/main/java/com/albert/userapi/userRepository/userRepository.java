package com.albert.userapi.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albert.userapi.User.User;

@Repository
public interface userRepository extends JpaRepository<User,Long> {

}