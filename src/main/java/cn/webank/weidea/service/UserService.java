package cn.webank.weidea.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.entity.User;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	private Pattern idCardMatcher = Pattern.compile(
			"^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
	private Pattern phoneMatcher = Pattern
			.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");

	public void register(User user) {
		if (userRepository.findPublishKey(user.getIdCard()) != null) {
			throw new CheckException("该身份证已存在");
		}
		if (!idCardMatcher.matcher(user.getIdCard()).matches()) {
			throw new CheckException("身份证格式错误");
		}

		if (user.getSex() != 0 && user.getSex() != 0) {
			throw new CheckException("性别错误");
		}

		if (!phoneMatcher.matcher(user.getPhone()).matches()) {
			throw new CheckException("手机号错误");
		}
	}

}
