package com.tests.practice;

public class Main {
    public static void main(String[] args) {
        bird brd = new bird(2,"twetty",'F');
        brd.eat();
        brd.fly();
        brd.sleep();

        dog bobi = new dog(3,"bobi",'M');
        bobi.eat();
        bobi.run();
        bobi.sleep();

    }
}
