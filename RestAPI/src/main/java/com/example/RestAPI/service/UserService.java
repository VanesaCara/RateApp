package com.example.RestAPI.service;

import com.example.RestAPI.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RestAPI.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

 public User findById(int id){
     return repository.findById(id).orElse(null);
 }
 public List<User> getAllUsers(){
     return repository.findAll();
 }
 public User addUser(User user){
     return repository.save(user);
 }
public User updateUser(User user){
   User existingUser = repository.findById(user.getUid()).orElse(null) ;

   if (existingUser==null) return null;

   existingUser.setName(user.getName());
   existingUser.setEmail(user.getEmail());
   existingUser.setPassword(user.getPassword());
   return repository.save(existingUser);
}

public String deleteAllUsers(){
     repository.deleteAll();
     return "All Users are deleted";
}
public String deleteAnUserById(int id){
     repository.deleteById(id);
     return "User removed" ;
}
public User findByEmail(String email){
     return repository.findByEmail(email);
}
}
