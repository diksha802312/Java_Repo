package DesignPattern.BuilderPattern;

public class User {
    private String name;
    private int age;
    private String gender;
    private String email;

    private User(UserBuilder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.email = builder.email;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Email: " + email;
    }

    static class UserBuilder{
        private String name;
        private int age;
        private String gender;
        private String email;

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public UserBuilder setGender(String gender){
            this.gender = gender;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
