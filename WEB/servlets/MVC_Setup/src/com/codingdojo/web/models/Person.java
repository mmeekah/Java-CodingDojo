package com.codingdojo.web.models;

public class Person {
	
	
	//Attributes
    private String name;
    private int age;
    
    //Constructor
    public Person(){
    }
    
    
    
    
    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }
    
    
    //Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    
    //Method
    public String greeting(){
        return "Hello! My name is " + name + ". and I am " + age + " years old.";
    }
}