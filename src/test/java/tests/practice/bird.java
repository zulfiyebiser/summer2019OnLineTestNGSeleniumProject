package tests.practice;

public class bird extends Animal {
    public bird(int age, String name, char gender) {
        super(age, name, gender);
    }
    public  void fly(){
        System.out.println("birds are flying");
    }

    @Override
    public void sleep() {

        System.out.println("birds are sleeping ");
    }

    @Override
    public void eat() {

        System.out.println("birds are eating seeds");
    }
}
