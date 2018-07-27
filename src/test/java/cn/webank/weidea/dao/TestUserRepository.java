package cn.webank.weidea.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webank.weidea.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:config/applicationContext.xml" })
public class TestUserRepository {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {
		try {
			int count = userRepository.count();
			String idCard = String.valueOf(System.currentTimeMillis());
			userRepository.save(new User(idCard, idCard + "aa", "123456789", 1, "a", idCard + "bb"));
			Assert.assertEquals(count + 1, userRepository.count());
			String name = userRepository.findPublishKey(idCard);
			Assert.assertEquals(idCard + "bb", name);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
