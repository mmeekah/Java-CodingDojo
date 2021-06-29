package com.codingdojo.zoo;


public class Gorilla extends Mammal {
	
	//Print out a message indicating that the gorilla has thrown something, 
	//as well as decrease the energy level by 5:
	public void throwSomething() {
		System.out.println("The gorilla threw some banana peels");
		this.setEnergyLevel(this.getEnergyLevel() - 5);
	}
	
	//Print out a message indicating the gorilla's satisfaction and increase its energy by 10:
	public void eatBanana() {
		System.out.println("The gorilla seems satisfied as it finished eating banana");
		this.setEnergyLevel(this.getEnergyLevel() + 10);
	}
	
	//print out a message indicating the gorilla has climbed a tree and decrease its energy by 10
	public void climb() {
		System.out.println("WOW, the gorilla is climbing the building");
		this.setEnergyLevel(this.getEnergyLevel() - 10);
	}

}
