package org.example;

public class PersonBuilder {

    private String name;
    private String lastName;
    private int age = -1;
    private boolean isAgeDefined = false;
    private String address;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder age(int age) {
        if (age >= 0) this.age = age;
        isAgeDefined = true;
        return this;
    }

    public PersonBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Person build () {
        // Метод isBlank проверяет, что строка пуста или состоит из пробелов
        if (this.age < 0 && isAgeDefined) throw new IllegalArgumentException("Возраст не может быть меньше 0");
        if (name == null || name.isBlank()) throw new IllegalStateException("Не допускается создание персонажа без имени");
        if (lastName == null || lastName.isBlank()) throw new IllegalStateException("Не допускается создание персонажа без фамилии");
        return new Person(name, lastName, age, address);
    }
}
