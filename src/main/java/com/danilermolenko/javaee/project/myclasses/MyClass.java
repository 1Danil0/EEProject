package com.danilermolenko.javaee.project.myclasses;

public class MyClass<T> {
    T field;

    public MyClass(T field){
        this.field = field;
    }

    public T getField() {
        return field;
    }
}
