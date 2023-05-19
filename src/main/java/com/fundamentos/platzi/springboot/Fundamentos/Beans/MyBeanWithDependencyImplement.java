package com.fundamentos.platzi.springboot.Fundamentos.Beans;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Clase printWithDependency invocada...");
        System.out.println("suma: " + myOperation.sum(1,1));
        System.out.println("Hola desde implementacion de Bean con dependencia!");
    }
}
