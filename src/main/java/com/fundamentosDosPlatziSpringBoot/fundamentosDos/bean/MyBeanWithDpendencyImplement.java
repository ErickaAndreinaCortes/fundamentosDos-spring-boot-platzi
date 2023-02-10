package com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDpendencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDpendencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDpendencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDepedency() {
        LOGGER.info("hemos ingresado al metodo blablablabla");
        int numero = 1;
        LOGGER.debug("El número enviado como parametro a la dependencia operation es " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implemenatción de un bean con dependencia");
    }
}
