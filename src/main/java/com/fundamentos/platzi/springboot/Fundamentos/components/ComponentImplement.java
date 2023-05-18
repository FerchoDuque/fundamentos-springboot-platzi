package com.fundamentos.platzi.springboot.Fundamentos.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde componente!");
    }
}
