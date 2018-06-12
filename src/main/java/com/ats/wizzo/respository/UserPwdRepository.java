package com.ats.wizzo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.wizzo.model.UserPwd;

public interface UserPwdRepository extends JpaRepository<UserPwd, Integer> {

}
