package com.guier.configclient.dao;

import com.guier.configclient.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

}
