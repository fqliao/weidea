package cn.webank.weidea.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.webank.weidea.util.HttpUtil;
import cn.webank.weidea.util.PathUtil;

@Service
public class SecretKeyService {
	public static void main(String[] args) {
		SecretKeyService secretKeyService = new SecretKeyService();
		secretKeyService.createSecretKey("aaa", "bbb");
	}

	public void createSecretKey(String idCard, String token) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("idCard", idCard);
		paramsMap.put("token", token);
		System.out.println(HttpUtil.postMap(PathUtil.URL + PathUtil.CREATE_SECRET_KEY_PATH,
				"idCard:\"asdasda\",token,\"sadsad\""));
	}

	public void decryptSecretKey(String idCard, String token, String ciphertext) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("idCard", idCard);
		paramsMap.put("token", token);
		paramsMap.put("ciphertext", ciphertext);
		// HttpUtil.postMap(PathUtil.DECRYPT_PATH, paramsMap);
	}
}
