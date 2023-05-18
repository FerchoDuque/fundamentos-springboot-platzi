package com.fundamentos.platzi.springboot.Fundamentos.Beans;

public class MyBeanWithPropertiesImplements implements MyBeanWithProperties {

    private String name;
    private String lastName;

    public MyBeanWithPropertiesImplements(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String function() {
        return name + "-" + lastName;
    }
}
