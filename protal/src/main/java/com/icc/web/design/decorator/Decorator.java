package com.icc.web.design.decorator;

public class Decorator extends ComPonent {

    public ComPonent comPonent;

    public Decorator(ComPonent comPonent) {
        this.comPonent = comPonent;
    }

    @Override
    public void work() {
        comPonent.work();
    }
}


