package com.fundamentos.platzi.springboot.Fundamentos.Beans;

public class MyOperationImplement implements MyOperation{
    @Override
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
}
