package cn.webank.weidea.util;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.kenai.jffi.Main;

import sun.misc.BASE64Decoder;

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
	
	//公钥加密
	public String Encrypt(String publicKey,String text) {
		String plaintext = null;
		
        try {
        	//数据格式转换
        	byte[] keyBytes;
			keyBytes = (new BASE64Decoder()).decodeBuffer(publicKey);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey public_key = keyFactory.generatePublic(keySpec);
			
			//加密
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, public_key);
			byte[] results=cipher.doFinal(text.getBytes("UTF-8"));
			plaintext = new String(Base64.encodeBase64(results));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return plaintext;
	}
	
	//私钥解密
	public String Decrypt(String key,String ciphertext) {
		String plaintext = null;
		
        try {
        	//数据格式转换
        	byte[] keyBytes;
			keyBytes = (new BASE64Decoder()).decodeBuffer(key);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
			
		
			
			byte[] txtBytes;
			txtBytes = (new BASE64Decoder()).decodeBuffer(ciphertext);
			
			//解密
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			plaintext = new String(cipher.doFinal(txtBytes),"UTF-8");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plaintext;
	}
	
	public String getPublicKey() {
		return publicKey_str;
	}
	
	public String getPrivateKey() {
		return privateKey_str;
	}
	
	public static void main(String[] args) {
		EncryptUtils testUtils = new EncryptUtils();
		testUtils.SecretKey();
		String publicKey = testUtils.getPublicKey();
		String privateKey = testUtils.getPrivateKey();
		
		
		try {
			//数据格式转换
			byte[] keyBytes;
            keyBytes = (new BASE64Decoder()).decodeBuffer(publicKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey public_key = keyFactory.generatePublic(keySpec);
            RSAPublicKey rsaPublicKey = (RSAPublicKey) public_key;
			
			//加密
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, public_key);
			byte[] results=cipher.doFinal("我是要被加密的数据！".getBytes("UTF-8"));
			String result = new String(Base64.encodeBase64(results));
			
			String result2 = testUtils.Encrypt("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApVTEyUSofS+WvoruDfqSDCFgZuNAJzNvAw8wsnvd+TzK3lwTNJOt9jzy3YtwMJ11eDRRxhhE5f89KChfiRUkPisEpTGJXT2uZi9j/JAx5vdXqjMm4EbE5ep07P+GQM4tvOSTcFzTAPQkAb/7VHhTIcs1AgzW0fPqZOFq2wiUrBIHqhdfo46jxDAtRcNrQiTMgqIuSMP/lXrJ6izn66kRE6Kd6H0If9SDZqbEawb+14d3bJn6xkANgURC/7bwgc4sEuwLbAUSNKvSFWdFz7Xyt5npq4NqT2d2B3qEOZRqIuU4H0kiU3dKnNnQaQAT+wPA0lUGMoIwCWRx1v8jkhfXawIDAQAB", "测试加密方法");
			System.out.println("加密后的数据："+result2);
			
			//解密
			String testString = testUtils.Decrypt("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClVMTJRKh9L5a+iu4N+pIMIWBm40AnM28DDzCye935PMreXBM0k632PPLdi3AwnXV4NFHGGETl/z0oKF+JFSQ+KwSlMYldPa5mL2P8kDHm91eqMybgRsTl6nTs/4ZAzi285JNwXNMA9CQBv/tUeFMhyzUCDNbR8+pk4WrbCJSsEgeqF1+jjqPEMC1Fw2tCJMyCoi5Iw/+VesnqLOfrqRETop3ofQh/1INmpsRrBv7Xh3dsmfrGQA2BREL/tvCBziwS7AtsBRI0q9IVZ0XPtfK3memrg2pPZ3YHeoQ5lGoi5TgfSSJTd0qc2dBpABP7A8DSVQYygjAJZHHW/yOSF9drAgMBAAECggEAeZ9hYDpMxELE3wju1IO2+ot3ElkscWoJyTNcfIBYq6fICUmsqynUeGcftlCESI8cwj+ixFpIHPXltGv2064kykL1GNzXEytz5yIHqN0eiKz95WvZtnT5FbWjLFFRHs1Noj54I9l1M6dl8Y+cQOh/J0YIiaiOQ0bu8CVPaS/nxqgRim2ZsuWUaVv/5QDkMKb6O+bPD6T7+Bp2ionsHeTq7+lvKrWAGTr0Uh/xU+xZsNCBYh9Io596Vl02XBoq214TyeIgLeTiRMGqU5sMVmxG9NenVewaxwIZWbvpvTIKeFmhe6davRE/d8UI/gOrA2llj07QxRkgbcok4Kb4xKO2MQKBgQDa++FnsVMLMXiZnBbcfNkuwvJuf7PI9iN502UIkwMrQmXoqiKQ86bHPDPANd0ZhY39DL1+OEyZHXL03GErzgYj1u8PrINJ3RDu4wp8JN1rGskpGtn+Rtj9ZZ47DI42rb3Aa7vaxcqsBORJ9r/NC81JSJZQtfi9eZKItTye3v0nSQKBgQDBRyoUK+cz4UwngkUN56km/dAtby+pQ8HhhjrNwVhPHCzR8CDcItwo9jlfw2S7h5q5uYGeMEARQi5isldG0MIjIoxqovMSBS8GcsVJ6A5e/DTJQ93KbbUL4RRxGeNf4l6aI/W/BqbjHnKoCXs/7MCG4VTOWSrn1rXrDMPSh72FEwKBgG/RuKrTUH1huJxvqPjTw67uGw8zpGFU1o6p1GiJcU/QqusgnV/5GsuXwTFAD/OtT/DMZaKjKvHwqLfCJNhSbq40XYRaafv4p2Hki4ES7gF3/wo/TNtb4AecsSyj36aqFz+/g4BWCYTHRq9CEXSptxzZtO/ny+kswBeQvDC/2vMJAoGAJoHIJ2ar1JFBe+mfWmraL5OH41VwmHeQbB8zHgU0U+aYI2eFFHa5iEuuGJ80NYyJzhDgeyS/zvBxj2ZarxguZZOfiCtY5DE2MkGxfs0F9/Sli6fCy27aEDjSusnenB7cnDcn4dwwabWKQGJLNOw1W2oPXGE1hCUp71+GsC4tGxMCgYEAsvIesQwQocya2aXsgOLlVO7JHzX5837Kf0hBpGzR+kCirwem0wvGiTAnEmRnwkHh+UBjtQrxgQhPZtbYqApjhKut5RsyLnjJFYfg4EV6vKwZ9R4rYN1l2CbBj7cHMkvR0/VeAUW7lS9j6hZBOjkQ4rp51PgTMOj0Qi9pQsdpMU4=", result2);
			
			System.out.println(testString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
