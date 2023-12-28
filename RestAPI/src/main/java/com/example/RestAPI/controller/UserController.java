package com.example.RestAPI.controller;

import com.example.RestAPI.configuration.PasswordUtils;
import com.example.RestAPI.dto.LoginDto;
import com.example.RestAPI.dto.UserDto;
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


    @CrossOrigin("*")
    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable Integer id){

        User user=userService.findById(id);
        UserDto userDto=user.convertUserToUserDto();
        return userDto;
    }


    @PostMapping("/addUser")
    public ResponseEntity<?> addUser (@RequestBody User user){
        if(userService.findByEmail(user.getEmail())!= null){
            return new ResponseEntity<String>("Email already exists !" , HttpStatus.BAD_REQUEST);
        }else {
            String hashedPwd = PasswordUtils.hashPassword(user.getPassword());
            user.setPassword(hashedPwd);
            userService.addUser(user);
            return  new ResponseEntity<String>("Usser added",HttpStatus.OK);
        }
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

@PostMapping("/login")
public ResponseEntity<?> login (@RequestBody LoginDto user){
        User userInDB=userService.findByEmail(user.getEmail());
        if(userInDB==null){
            return new ResponseEntity<String>("Email not found",HttpStatus.NOT_FOUND);
        }
        boolean verify=PasswordUtils.verifyPassword(user.getPassword(),userInDB.getPassword());
        if(verify) return new ResponseEntity<String>("Login succesful",HttpStatus.OK);
        else return  new ResponseEntity<String>("Incorrect password",HttpStatus.NOT_ACCEPTABLE);
}
}

