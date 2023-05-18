package com.fundamentos.platzi.springboot.Fundamentos.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola desde componente dos!");
    }
}
