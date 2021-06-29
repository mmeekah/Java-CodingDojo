package com.codingdojo.phone;

public class PhoneTest {
	public static void main(String[] args) {
		Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Doo Be Doo Be Doo!");
		IPhone iPhoneXI = new IPhone("XI", 100, "T-Mobile", "Ring ring ring!");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iPhoneXI.displayInfo();
		System.out.println(iPhoneXI.ring());
		System.out.println(iPhoneXI.unlock());
	}
}
