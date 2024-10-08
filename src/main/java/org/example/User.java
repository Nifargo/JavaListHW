package org.example;

public class User <T> {
    private String name;
    private Integer age;

    public User(T name, Integer age) {
        this.name = (String) name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
