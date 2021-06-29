import java.lang.Math;

public class Pythogorean {
	
	public static void main (String [] args) {
		
		System.out.println(calcHypotenuse(4,4));
	}
	
	
	public static double calcHypotenuse(int legA, int legB) {
		return Math.sqrt((legA* legA)+(legB * legB));
		
	}
	
	
	
	
}
