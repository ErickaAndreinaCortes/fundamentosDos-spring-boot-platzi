package com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean;

public class MyBeanWithPrpertiesImplement implements MyBeanWithPrperties{


    private String nombre;
    private String apellido;

    public MyBeanWithPrpertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
