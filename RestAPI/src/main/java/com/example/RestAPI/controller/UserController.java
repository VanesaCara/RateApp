package com.example.RestAPI.controller;

import com.example.RestAPI.entity.User;
import com.example.RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }


    @PostMapping("/addUser")
    public User addUser (@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping ("/allUsers")
    public List<User> getAllUsers (){
        return userService.getAllUsers();
    }

@PutMapping("/updateUser")
    public ResponseEntity<?> update(@RequestBody User user){
        User updatedUser=userService.updateUser(user);
        if(updatedUser==null){
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<User>(updatedUser,HttpStatus.OK);

}
@DeleteMapping("/deleteUsers/{id}")
    public String deleteUserByid(@PathVariable int id){
        return userService.deleteAnUserById(id);
}
@DeleteMapping("/deleteAll")
public String deleteAllUsers (){
       return userService.deleteAllUsers();

}
@GetMapping("/userbymail/{email}")
public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
}
}

