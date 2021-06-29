
public class Animal {
	
	String animal;
	int age;
	String gender;
	int weight;
	
	
	public Animal(String animal,int age, String gender, int weight) {
		super();
		this.animal = animal;
		this.age = age;
		this.gender = gender;
		this.weight=weight;
		
	}
	
	public void speak () {
		System.out.println("I'am a "+animal);
		System.out.println("I am "+age + " years old!");
		System.out.println("I am "+height + " cm tall");
		System.out.println("My eye color is "+eyeColor);
	}
	
	public void eat() {
		System.out.println("Eating...");
	}
	public void walk() {
		System.out.println("Walking...");
	}

}
