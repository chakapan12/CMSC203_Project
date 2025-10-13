import static org.junit.Assert.*;

import org.junit.Test;

public class CryptoManagerTestStudent {

	@Test
	public void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("ASSINGMENT3"));
		assertFalse(CryptoManager.isStringInBounds("Assignment3"));
		assertFalse(CryptoManager.isStringInBounds("Assignment3 #$%^"));	
	}

	@Test
	public void testVigenereEncryption() {
		String plain = "CHAKAPAN 2025!";
        String key = "TOP123!";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
	}


	@Test
	public void testPlayfairEncryption() {
		String plain = "CHAKAPAN 2025!";
        String key = "TOP123!";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain, decrypted);
	}

	@Test
	public void testCaesarEncryption() {
		String plain = "CHAKAPAN 2025!";
        int key = 5;
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(plain, decrypted);       
	}



}
