package com.tests.practice;

public class Animal {
    private int age;
    private  String name;
    private char gender;

   public  Animal(int age,String name,char gender){
       this.age = age;
       this.name = name;
       this.gender = gender;

   }



    public void eat(){
       System.out.println("eating");
   }
   public void sleep(){
       System.out.println("sleeping");
   }
}
