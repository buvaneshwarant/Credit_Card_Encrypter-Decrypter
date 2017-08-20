package main;

import creditCards.*;
import creditCardEncryptions.*;

public class Main {
		
	public static void main(String[] args) throws Exception {
			RegularCreditCard card1 = new RegularCreditCard("CapitalOne", "1234567812345678"); 
			AESencryption encriptCard1 = new AESencryption(card1); 
			System.out.println("Encrypted Value " + AESencryption.getEncryption());
			System.out.println("Encrypted Value " + AESencryption.getDecryption());
		}

}
