package com.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, IUserCustomRepository{

}
