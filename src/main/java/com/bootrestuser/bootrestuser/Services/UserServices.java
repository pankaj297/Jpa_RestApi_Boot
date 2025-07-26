package com.bootrestuser.bootrestuser.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootrestuser.bootrestuser.Model.User;
import com.bootrestuser.bootrestuser.Repository.UserRepository;

@Component
public class UserServices {
    
    @Autowired
    private UserRepository userRepository;

    //* Get All Users
    public List<User> getAllUser() {
        return (List<User>) this.userRepository.findAll();

    }
    
    //*Get Single User */
    public User getUser(long id) {
        User user = null;
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    //*Create User */
    public User createUser(User user) {
        User create = userRepository.save(user);
        return create;
    }
    
    //*Update User */
    public User updateUser(User user, long uId) {
        user.setId(uId);
        return userRepository.save(user);
    }
    
    //*Delete User */
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    
    }
    
}
