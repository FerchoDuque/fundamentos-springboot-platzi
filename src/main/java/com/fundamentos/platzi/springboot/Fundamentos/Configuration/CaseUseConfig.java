package com.fundamentos.platzi.springboot.Fundamentos.Configuration;

import com.fundamentos.platzi.springboot.Fundamentos.caseuse.GetUser;
import com.fundamentos.platzi.springboot.Fundamentos.caseuse.GetUserImplement;
import com.fundamentos.platzi.springboot.Fundamentos.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfig {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
