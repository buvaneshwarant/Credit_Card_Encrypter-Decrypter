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
