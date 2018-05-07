package com.ats.wizzo.util;

import java.security.SecureRandom;
import java.util.Random;

public  class AuthKeyGenerator {

	static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	final private Random rng = new SecureRandom();    

	char randomChar(){
	    return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
	}

	public String randomUUID(int length ){
	    StringBuilder sb = new StringBuilder();
	    while(length > 0){
	      
	        length--;
	        sb.append(randomChar());
	    }
	    return sb.toString();
	}

	
	
}
