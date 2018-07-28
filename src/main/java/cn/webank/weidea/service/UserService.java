package cn.webank.weidea.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webank.weidea.dao.UserRepository;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.entity.User;
import cn.webank.weidea.model.Result;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	private Pattern idCardMatcher = Pattern.compile(
			"^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
	private Pattern phoneMatcher = Pattern
			.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");
	@Autowired
	private SecretKeyService secretKeyService;

	public void register(User user) {
		String publishKey = userRepository.findPublishKey(user.getIdCard());
		if (publishKey != null && publishKey.length() > 0) {
			throw new CheckException("该身份证已存在");
		}
		if (!idCardMatcher.matcher(user.getIdCard()).matches()) {
			throw new CheckException("身份证格式错误");
		}

		if (user.getSex() != 0 && user.getSex() != 1) {
			throw new CheckException("性别错误");
		}

		if (!phoneMatcher.matcher(user.getPhone()).matches()) {
			throw new CheckException("手机号错误");
		}
	}

	public static void main(String[] args) {
		Result<String> result = new SecretKeyService().decryptSecretKey("441422199605104017", "123456", "aa");
		System.out.println();
	}

	public void login(User user) {
		String idCard = user.getIdCard();
		if (idCard == null || idCard.length() == 0) {
			throw new CheckException("请输入身份证");
		}
		String publicKey = userRepository.findPublishKey(user.getIdCard());
		if (publicKey == null || publicKey.length() == 0) {
			throw new CheckException("该用户不存在");
		}
		Result<String> result = secretKeyService.decryptSecretKey(idCard, user.getToken(), "aa");
		if (result.getCode() == 1 && "密码错误".equals(result.getErrorMsg())) {
			throw new CheckException("token错误");
		}
	}

}
