package cn.webank.weidea.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.model.Result;
import cn.webank.weidea.util.HttpUtil;
import cn.webank.weidea.util.PathUtil;

@Service
public class SecretKeyService {
	public String getPublishKey(String idCard, String token) {
		Result<String> result = createSecretKey(idCard, token);
		if (result.getCode() == 0) {
			return result.getData();
		}
		throw new CheckException(result.getErrorMsg());
	}

	public Result<String> createSecretKey(String idCard, String token) {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("idCard", idCard);
		paramMap.put("token", token);
		return new Gson().fromJson(
				HttpUtil.postMap(PathUtil.URL + PathUtil.CREATE_SECRET_KEY_PATH, new Gson().toJson(paramMap)),
				new TypeToken<Result<String>>() {
				}.getType());
	}

	public String getPlaintext(String idCard, String token, String ciphertext) {
		Result<String> result = decryptSecretKey(idCard, token, ciphertext);
		if (result.getCode() == 0) {
			return result.getData();
		}
		throw new CheckException(result.getErrorMsg());
	}

	public Result<String> decryptSecretKey(String idCard, String token, String ciphertext) {
		Map<String, String> paramsMap = new HashMap<>();
		paramsMap.put("idCard", idCard);
		paramsMap.put("token", token);
		paramsMap.put("ciphertext", ciphertext);
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("idCard", idCard);
		paramMap.put("token", token);
		paramMap.put("ciphertext", ciphertext);
		return new Gson().fromJson(HttpUtil.postMap(PathUtil.URL + PathUtil.DECRYPT_PATH, new Gson().toJson(paramMap)),
				new TypeToken<Result<String>>() {
				}.getType());
	}
}
