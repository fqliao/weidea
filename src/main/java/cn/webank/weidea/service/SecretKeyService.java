package cn.webank.weidea.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.webank.weidea.entity.User;
import cn.webank.weidea.util.HttpUtil;
import cn.webank.weidea.util.PathUtil;

@Service
public class SecretKeyService {
	public static void main(String[] args) {
		System.out.println(new Gson().toJson(new User("a", "a", "a", 1, "a", "a")));
	}

	public void createSecretKey(String idCard, String token) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("idCard", idCard);
		paramsMap.put("token", token);
		HttpUtil.postMap(PathUtil.CREATE_SECRET_KEY_PATH, paramsMap);
	}

	public void decryptSecretKey(String idCard, String token, String ciphertext) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("idCard", idCard);
		paramsMap.put("token", token);
		paramsMap.put("ciphertext", ciphertext);
		HttpUtil.postMap(PathUtil.DECRYPT_PATH, paramsMap);
	}
}
