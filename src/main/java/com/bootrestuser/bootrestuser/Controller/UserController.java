package com.bootrestuser.bootrestuser.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootrestuser.bootrestuser.Model.User;
import com.bootrestuser.bootrestuser.Services.UserServices;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    //*Get All User Controller */
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userServices.getAllUser();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/user/{gId}")
    public ResponseEntity<User> getUser(@PathVariable("gId") long gId) {
        User user = userServices.getUser(gId);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User saveUser = null;
        try {
            saveUser = userServices.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/user/{uId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("uId") long uId) {

        try {
            this.userServices.updateUser(user, uId);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        //    try{
        //         userServices.deleteUser(id);
        //         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        //    }
    try {
        userServices.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
    }

    }

}
