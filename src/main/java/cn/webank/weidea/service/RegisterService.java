package cn.webank.weidea.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.controller.RegisterController;
import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.entity.User;
import cn.webank.weidea.util.EncryptUtils;

@Service
public class RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	private SecretKeyService secretKeyService;

	public boolean register(User user) {
		try {
			varifyUserInfo(user);
			String pkey = secretKeyService.getPublishKey(user.getIdCard(), user.getToken());
			LOGGER.info("从第三方机构获取公钥" + pkey);
			user.setPublishKey(pkey);
			User encryptUser = new User();
			// 加密
			encryptUser.setUsername(new EncryptUtils().Encrypt(user.getPublishKey(), user.getUsername()));
			encryptUser.setPhone(new EncryptUtils().Encrypt(user.getPublishKey(), user.getPhone()));
			encryptUser.setIdCard(user.getIdCard());
			encryptUser.setPublishKey(user.getPublishKey());
			encryptUser.setSex(user.getSex());
			// 上链
			userRepository.save(encryptUser);
			LOGGER.info("用户信息密文上链成功");

			// 传输口令给第三方
			return true;

		} catch (CheckException ce) {
			return false;
		}
	}

	private void varifyUserInfo(User user) {
		if (user != null) {
			userService.register(user);
		}
	}

}
