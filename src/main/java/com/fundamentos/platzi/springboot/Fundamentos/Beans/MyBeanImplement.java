package com.fundamentos.platzi.springboot.Fundamentos.Beans;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde implementacion MyBean!");
    }
}
