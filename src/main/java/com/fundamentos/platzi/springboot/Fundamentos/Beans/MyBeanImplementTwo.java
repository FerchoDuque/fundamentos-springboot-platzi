package com.fundamentos.platzi.springboot.Fundamentos.Beans;

public class MyBeanImplementTwo implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde implementacion MyBean Two!");
    }
}
