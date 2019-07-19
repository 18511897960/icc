package com.icc.web.design.decorator;

public class DecoratorA extends  Decorator {

    public DecoratorA(ComPonent comPonent) {
        super(comPonent);
    }

    @Override
    public void work() {
        System.out.println("workb");
        super.work();
    }
}