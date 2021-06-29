package com.codingdojo.zoo;

public class Mammal {
	
	// Set mammals' default energy level to 100:
	private int energyLevel = 100;
	
	//Empty constructor
	public Mammal() {}
	
	//Method shows the animals energy level
	public int displayEnergy() {
		System.out.println(this.energyLevel);
//		if (this.energyLevel == 0) 
//			System.out.println("The animal has no energy left");
//		
//		else 
		return energyLevel;
		
	}
	
	// Getter and setter methods for the energy level attribute
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void setEnergyLevel(int energy) {
		this.energyLevel = energy;
	}
}
