package com.fundamentos.platzi.springboot.Fundamentos.controllers;

import com.fundamentos.platzi.springboot.Fundamentos.caseuse.GetUser;
import com.fundamentos.platzi.springboot.Fundamentos.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //Create, get, delete, update
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/get-all-users")
    List<User> get(){
        return getUser.getAll();
    }
}
