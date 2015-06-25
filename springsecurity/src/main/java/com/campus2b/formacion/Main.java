package com.campus2b.formacion;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class Main {

	public static void main(String[] args) {
			try {
				Field field = Class.forName("javax.crypto.JceSecurity").
				getDeclaredField("isRestricted");
				field.setAccessible(true);
				field.set(null, java.lang.Boolean.FALSE);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			final String password = "I AM SHERLOCKED";  
		    final String salt = KeyGenerators.string().generateKey();
		
		    TextEncryptor encryptor = Encryptors.text(password, salt);      
		    System.out.println("Salt: \"" + salt + "\"");
		
		    String textToEncrypt = "*esto es secreto*";
		    System.out.println("Texto Original: \"" + textToEncrypt + "\"");
		
		    String encryptedText = encryptor.encrypt(textToEncrypt);
		    System.out.println("Texto Encriptado: \"" + encryptedText + "\"");
		
		    // Could reuse encryptor but wanted to show reconstructing TextEncryptor
		    TextEncryptor decryptor = Encryptors.text(password, salt);
		    String decryptedText = decryptor.decrypt(encryptedText);
		    System.out.println("Texto Desencriptado: \"" + decryptedText + "\"");
		
		    if(textToEncrypt.equals(decryptedText)) {
		        System.out.println("Exito!! :-)");
		    } else {
		        System.out.println("Fracaso :-(");
		    }  
		    
		    BytesEncryptor en = Encryptors.standard(textToEncrypt, salt);
			try {
				byte[] result = en.encrypt(textToEncrypt.getBytes("UTF-8"));
				
				byte[] original= en.decrypt(result);
				System.out.println(new String (original));
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
