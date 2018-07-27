package cn.webank.weidea.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.controller.RegisterController;
import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.entity.User;

@Service
public class RegisterService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);
	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserService userService;
	
	public boolean register(User user){
		try {
			varifyUserInfo(user);
			if(userRepository.findPublishKey(user.getIdCard())==null) {
				String pkey=getPulibcKeyFromPKI(user.getIdCard());
				LOGGER.info("从第三方机构获取公钥"+pkey);
				user.setPublishKey(pkey);
				//加密
				
				//上链
				userRepository.save(user);
				LOGGER.info("用户信息密文上链成功");
				System.out.println("用户信息密文上链成功");
				
				//传输口令给第三方
				return true;
			}
			
		}catch(CheckException ce) {
			ce.printStackTrace();
		}finally {
			return false;
		}		
	}
	
	private String getPulibcKeyFromPKI(String idCard) {
		
		//http请求，参数为user的id		
		return  "key";
	}
	
	private void varifyUserInfo(User user) {
		if(user!=null) {
			userService.register(user);
		}
	}

}
