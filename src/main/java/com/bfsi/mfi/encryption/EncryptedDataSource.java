package com.bfsi.mfi.encryption;

import java.io.IOException;

import javax.crypto.Cipher;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import sun.misc.BASE64Decoder;

public class EncryptedDataSource extends DriverManagerDataSource {

	Cipher ecipher;
    Cipher dcipher;
    // 8-byte Salt
    byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };
    // Iteration count
    int iterationCount = 19;
    public EncryptedDataSource() { 

    }
    
	@Override
	public String getUsername() {
		String username = super.getUsername();
		return decode(username);
	}

	@Override
	public String getPassword() {
		String password = super.getPassword();
		return decode(password);
	}

	private String decode(String decode) 
	{
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(decode);
		    decode = new String(decoder.decodeBuffer(decode));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return decode;
	}
	//
	
}