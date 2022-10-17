package org.example;

import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String lastName;
    private int age;

    // Будем держать возраст также в String для корректного вывода в toString если он не задан
    private String ageForPrint = "unknown";
    private String address;

    public Person(String name, String lastName, int age, String address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        if (age >= 0) ageForPrint = "" + age;
        this.address = address;
    }

    public OptionalInt getAge() {
        if (age >= 0) {
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        // isEmpty не считает пустой строку из пробелов, по этому используем isBlank
        return address != null && !address.isBlank();
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
            ageForPrint = "" + age;
            System.out.println("Поздравляем " + this.getName() + " " + this.getLastName() + " с " + this.age + "-летием");
        } else System.out.println("Возраст человека " + this.getName() + " " + this.getLastName() + " не известен");
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .lastName(this.lastName)
                .age(0)
                .address(this.address);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + ageForPrint +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
