package com.icc.web.design.decorator;

public class DecoratorB extends Decorator {

    public DecoratorB(ComPonent comPonent) {
        super(comPonent);
    }

    @Override
    public void work() {
        System.out.println("workc");
        super.work();
    }



    public static void main(String[] args) {
        ComPonent comPonent = new DecoratorB(new DecoratorA(new ComPonent()));
        comPonent.work();
    }

}