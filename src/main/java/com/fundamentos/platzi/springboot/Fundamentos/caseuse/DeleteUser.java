package com.fundamentos.platzi.springboot.Fundamentos.caseuse;

import com.fundamentos.platzi.springboot.Fundamentos.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id) {
        userService.deleteUser(id);
    }
}
