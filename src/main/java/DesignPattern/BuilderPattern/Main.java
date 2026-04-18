package DesignPattern.BuilderPattern;


//Builder Pattern
//Purpose: Create complex objects step-by-step.
//Used for immutable objects
//Reduces telescoping constructors
//Very common in Java (StringBuilder, Lombok @Builder)
public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder()
                .setName("Prateek Cutu")
                .setAge(25)
                .setEmail("prateekchaturvedi@gmail.com")
                .setGender("Female")
                .build();

        System.out.println(user.toString());
    }
}
