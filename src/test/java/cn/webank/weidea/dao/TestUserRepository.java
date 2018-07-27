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
			userRepository.save(new User(idCard, idCard + "aa", "123456789", 1, "a", "bb"));
			Assert.assertEquals(count, userRepository.count());
			count++;
			String name = userRepository.findName(idCard);
			Assert.assertEquals(idCard + "aa", name);
		} catch (Exception e) {
			Assert.fail();
		}
		System.out.println("success");
		System.exit(0);
	}
}
