package com.codingdojo.zoo;

public class BatTest {
	public static void main(String[] args) {
		//Create a new bat:
		Bat dracula = new Bat();
		
		// Have have it attack three towns: 
		dracula.attackTown();
		dracula.attackTown();
		dracula.attackTown();
		dracula.displayEnergy();
		System.out.print("\n");


		//Eat two humans:
		dracula.eatHumans();
		dracula.eatHumans();
		dracula.displayEnergy();
		System.out.print("\n");
		
		//fly twice:
		dracula.fly();
		dracula.fly();
		dracula.displayEnergy();
		System.out.print("\n");
		
		//Display the energy level:
		System.out.print("Dracula's enery level is: ");
		dracula.displayEnergy();
	}
}
