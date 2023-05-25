package com.fundamentos.platzi.springboot.Fundamentos.controllers;

import com.fundamentos.platzi.springboot.Fundamentos.caseuse.CreateUser;
import com.fundamentos.platzi.springboot.Fundamentos.caseuse.DeleteUser;
import com.fundamentos.platzi.springboot.Fundamentos.caseuse.GetUser;
import com.fundamentos.platzi.springboot.Fundamentos.caseuse.UpdateUser;
import com.fundamentos.platzi.springboot.Fundamentos.entities.User;
import com.fundamentos.platzi.springboot.Fundamentos.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {
    //Create, get, delete, update
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }

    @GetMapping("/get-all-users")
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/create-user")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/delele-user/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update-user/{id}")
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }

    @GetMapping("/get-users-pagination")
    List<User> getUserPagination(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
