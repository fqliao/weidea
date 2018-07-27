package cn.webank.weidea.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class EncryptUtils {
	private String publicKey_str;
	private String privateKey_str;
	
	public void SecretKey() {
		//产生钥匙对
		KeyPairGenerator keyPairGenerator;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			KeyPair keyPair=keyPairGenerator.generateKeyPair();
			PublicKey publicKey= keyPair.getPublic();
			PrivateKey privateKey=keyPair.getPrivate();
			
			byte[] publicKey_byte = publicKey.getEncoded();
			byte[] privateKey_byte = privateKey.getEncoded();
			
			//转换格式
			publicKey_str = new String(Base64.encodeBase64(publicKey_byte));
			privateKey_str = new String(Base64.encodeBase64(privateKey_byte));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getPublicKey() {
		return publicKey_str;
	}
	
	public String getPrivateKey() {
		return privateKey_str;
	}
}
