package com.fundamentos.platzi.springboot.Fundamentos.caseuse;

import com.fundamentos.platzi.springboot.Fundamentos.entities.User;
import com.fundamentos.platzi.springboot.Fundamentos.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.updateUser(newUser, id);
    }
}
