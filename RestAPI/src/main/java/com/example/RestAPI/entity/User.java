package com.example.RestAPI.entity;


import com.example.RestAPI.dto.UserDto;
import jakarta.persistence.*;


@Entity
@Table(name ="user" )
public class User {


@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int uid ;

    private String name ;
    private String email;
    private String password ;

    public User() {
    }

    public User(int uid, String name, String email, String password) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserDto convertUserToUserDto(){
        UserDto userDto=new UserDto();
        userDto.setUid(this.uid);
        userDto.setName(this.name);
        userDto.setEmail(this.email);
        //skip pwd
        return userDto;

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
