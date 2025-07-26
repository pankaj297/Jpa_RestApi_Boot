package com.bootrestuser.bootrestuser.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bootrestuser.bootrestuser.Model.User;


public interface UserRepository extends CrudRepository<User, Long> {
      

}
