package com.icc.web.design.decorator;

public class DecoratorC extends Decorator {

    public DecoratorC(ComPonent comPonent) {
        super(comPonent);
    }

    @Override
    public void work() {
        System.out.println("workd");
        super.work();
    }



    public static void main(String[] args) {
        ComPonent comPonent = new DecoratorC(new DecoratorB(new DecoratorA(new ComPonent())));
        comPonent.work();
    }

}