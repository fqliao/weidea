package cn.webank.weidea.service.Im;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.webank.weidea.dao.KeyManagementRepository;
import cn.webank.weidea.dto.DecryptReq;
import cn.webank.weidea.dto.KeyManagementRsp;
import cn.webank.weidea.entity.KeyManagement;
import cn.webank.weidea.service.KeyManagementService;
import cn.webank.weidea.util.EncryptUtils;
import cn.webank.weidea.util.TokenEncryptUtils;

@Service
@Transactional
public class KeyManagementServiceIm extends BaseServiceIm implements KeyManagementService {

	@Autowired
	KeyManagementRepository keyManagementDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public KeyManagementRsp secretKey(KeyManagement keyManagement) {
		KeyManagementRsp response = new KeyManagementRsp();
		
		System.out.println("===================="+keyManagement.getIdCard()+"==========================");
		int temp = keyManagementDao.exist(keyManagement.getIdCard());
		System.out.println("======================="+(temp > 0)+"==========================");
		if(temp > 0) {
			response.setCode(1);
			response.setErrorMsg("用户已存在");
			response.setData(null);
			
			return response;
		}
		
		//存储token
		TokenEncryptUtils tokenUtils = new TokenEncryptUtils();
		String token = tokenUtils.Encrypt(keyManagement.getToken(), "");
		keyManagement.setToken(token);
		
		//存储私钥
		EncryptUtils encryptUtils = new EncryptUtils();
		encryptUtils.SecretKey();
		keyManagement.setPrivateKey(encryptUtils.getPrivateKey());
		
		
		KeyManagement result = keyManagementDao.save(keyManagement);
		if(result != null) {
			response.setCode(0);
			response.setErrorMsg(null);
			response.setData(encryptUtils.getPublicKey());
		}else {
			response.setCode(1);
			response.setErrorMsg("录入信息失败");
			response.setData(null);
		}
		
		return response;
	}

	@Override
	public KeyManagementRsp Decrypt(DecryptReq req) {
		KeyManagementRsp response = new KeyManagementRsp();
		
		//获取记录
		KeyManagement record = keyManagementDao.searchRecord(req.getIdCard());
		if(record == null) {
			response.setCode(1);
			response.setErrorMsg("该用户不存在");
			response.setData(null);
			
			return response;
		}
		
		//验证token
		TokenEncryptUtils tokenUtils = new TokenEncryptUtils();
		String temp = tokenUtils.Encrypt(req.getToken(), "");
		System.out.println("========================"+temp+"=======================");
		System.out.println("========================"+record.getToken()+"=========================");
		if(!(record.getToken().equals(temp))) {
			response.setCode(1);
			response.setErrorMsg("密码错误");
			response.setData(null);
			
			return response;
		}
		
		//解密数据
		EncryptUtils encryptUtils = new EncryptUtils();
		String plaintext = encryptUtils.Decrypt(record.getPrivateKey(), req.getCiphertext());
		System.out.println("============================================");
		System.out.println(plaintext);
		System.out.println("============================================");
		if(plaintext == null) {
			response.setCode(1);
			response.setErrorMsg("解密失败");
			response.setData(null);
			
			return response;
		}
		
		response.setCode(0);
		response.setErrorMsg(null);
		response.setData(plaintext);
		
		return response;
	}

	

}
