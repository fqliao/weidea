package cn.webank.weidea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.entity.User;

@Service
public class RegisterService {
	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	UserService userService;
	
	public boolean register(User user){
		
		varifyUserInfo(user);
		if(userRepository.findPublishKey(user.getIdCard())==null) {
			String pkey=getPulibcKeyFromPKI(user.getIdCard());
			user.setPublishKey(pkey);
			//加密
			
			//上链
			//userRepository.save(user);
			
			//传输口令给第三方
			return true;
		}
		return true;
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
