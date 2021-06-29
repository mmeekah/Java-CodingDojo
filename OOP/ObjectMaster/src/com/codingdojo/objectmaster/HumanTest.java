package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		
//		Human ninja = new Human("Mika");
//		Human samurai = new Human("Rassul");
//		Human wizard = new Human("Alim");
//		
//		wizard.attack(ninja);
//		samurai.attack(wizard);
//		ninja.attack(samurai);
		
		Human testHuman1 = new Human("Garth");
		Human testHuman2 = new Human("Toby");
		Human testHuman3 = new Human("Keith");
		
		Wizard testWizard1 = new Wizard("Karazhan");
		Wizard testWizard2 = new Wizard("Khadgar");
		Wizard testWizard3 = new Wizard("Medivh");
		
		Ninja testNinja1 = new Ninja("Choi");
		Ninja testNinja2 = new Ninja("Raphael");
		Ninja testNinja3 = new Ninja("Donatello");
		
		Samurai testSamurai1 = new Samurai("Genji");
		Samurai testSamurai2 = new Samurai("Hanzo");
		Samurai testSamurai3 = new Samurai("Ji");
		
		testWizard1.fireball(testHuman1);
		testWizard2.heal(testHuman2);
		
		testNinja2.steal(testHuman3);
		testNinja1.runAway();
		
		testSamurai3.deathBlow(testNinja1);
		testSamurai2.meditate();
		testSamurai3.howMany();
		
		
		
		
		

	}

}
