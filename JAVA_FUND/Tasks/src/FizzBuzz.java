
public class FizzBuzz {

	public static void main(String[] args) {
		
		System.out.println(FizzBuzz(15));

	}

	public static String FizzBuzz (int num) {
		
		if (num % 3 == 0 && num % 5 ==0) {
//			System.out.println("FizzBuzz");
			return "FizzBuzz";
		}
		
		if ( num % 3 == 0) {
//			System.out.println("Fizz");
			return "Fizz";
		}
		
		if (num % 5 == 0) {
//			System.out.println("Buzz");
			return "Buzz";
		}
		
		
		
		return Integer.toString(num);
		
	}
}
