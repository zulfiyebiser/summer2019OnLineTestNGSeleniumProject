package tests.practice;

public class dog extends Animal {
    public dog(int age, String name, char gender) {
        super(age, name, gender);
    }

    public void run(){
        System.out.println("dogs are running");
    }
    @Override
    public void eat(){
        System.out.println("dog eat meat");
    }

    @Override
    public void sleep(){
        System.out.println("dogs are sleeping");
    }

}
