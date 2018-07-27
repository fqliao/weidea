package cn.webank.weidea.service.Im;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.webank.weidea.dao.KeyManagementRepository;
import cn.webank.weidea.dao.exception.KeyManagementException;
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
		
		//存储token
		TokenEncryptUtils tokenUtils = new TokenEncryptUtils();
		String token = tokenUtils.Encrypt(keyManagement.getToken(), "");
		keyManagement.setToken(token);
		
		//存储私钥
		EncryptUtils encryptUtils = new EncryptUtils();
		encryptUtils.SecretKey();
		keyManagement.setPrivateKey(encryptUtils.getPrivateKey());
		
		System.out.println("============================================");
		System.out.println(encryptUtils.getPrivateKey());
		System.out.println("============================================");
		
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

	

}
