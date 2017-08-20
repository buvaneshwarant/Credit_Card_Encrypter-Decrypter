/*
 *  Copyright (C) 2010-2017 Buvaneshwaran T
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */

package creditCardEncryptions;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import creditCards.RegularCreditCard;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESencryption {
	private static String cardNumber; 
	private static final byte[] keyValue = 
	        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
	        		'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	static String encryptedValue;
	
	public AESencryption(RegularCreditCard creditCard) {
		cardNumber = creditCard.getCardNumber(); 
	}
	
	public static String getEncryption() throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(cardNumber.getBytes());
        encryptedValue = new BASE64Encoder().encode(encVal);
        
        return encryptedValue;
    }
	
	public static String getDecryption() throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
	
	   private static Key generateKey() throws Exception {
	        Key key = new SecretKeySpec(cardNumber.getBytes(), "AES");
	        return key;
	}

}
