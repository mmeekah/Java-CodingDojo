package com.codingdojo.objectmaster;

public class Human {

	//Attributes
	protected String name ="";
	private int strength = 3;
	public int stealth =3;
	public int intelligence = 3;
	protected int health = 100;
	
	
	//Constructors
	
	public Human () {
		
	}
	
	public Human (String name) {
		this.name = name;
	}
	
	//Getters & Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getStealth() {
		return stealth;
	}
	
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	//Methods
	
	public void attack(Human human) {
		human.setHealth(human.getHealth()-strength);
		System.out.println(this.getName() + " attacked " + human.getName() + " for "+ this.getStrength() + " damage!");
	}
}
