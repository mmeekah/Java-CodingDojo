package com.codingdojo.phone;


public interface Ringable {

	public default String ring() {
		return "Bzz Bzz Bzz!";
	}
	public default String unlock() {
		return "Click! - Phone unlocked!";
	}
	
	
	
}
