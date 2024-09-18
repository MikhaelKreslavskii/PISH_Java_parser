package org.example;

public class Individual extends Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String surname;
    private boolean hasChildren;
    private int age;

    private static int count =0;

    Individual(long id,
               String email,
               String phone,
               String address,
               BankAccount bankAccount,
               String name,
               String surname,
               boolean hasChildren,
               int age
    ) {

        super(id, email, phone, address, bankAccount);
        this.name = name;
        this.surname = surname;
        this.hasChildren = hasChildren;
        this.age = age;
        count++;
    }

    public static int getCountOfIndividuals()
    {
        return count;
    }
}