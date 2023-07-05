package com.poc.paybylink.repository;


import com.poc.paybylink.dao.UserLoginDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserLoginDao, Long> {

}

