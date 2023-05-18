package com.fundamentos.platzi.springboot.Fundamentos.Beans;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println("suma: " + myOperation.sum(1,1));
        System.out.println("Hola desde implementacion de Bean con dependencia!");
    }
}
