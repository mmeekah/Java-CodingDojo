package com.codingdojo.zoo;

public class Bat extends Mammal {
	//Set default energy level for the bat:
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	//Print the sound a bat taking off and decrease its energy by 50.
	public void fly() {
		System.out.println("Dracula spread its wings and is flying");
		this.setEnergyLevel(this.getEnergyLevel() - 100);
	}
	
	//Print the so- well, never mind, just increase its energy by 25:
	public void eatHumans() {
		System.out.println("Dracula cought and attacked the priest and sucking his blood out");
		this.setEnergyLevel(this.getEnergyLevel() + 25);
	}
	
	//Print the sound of a town on fire and decrease its energy by 100:
	public void attackTown() {
		System.out.println("We are being attacked! Everyone run to the church!!");
		this.setEnergyLevel(this.getEnergyLevel() - 50);
	}

}
