package cn.webank.weidea.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webank.weidea.entity.MedicalRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:config/applicationContext.xml" })
public class TestMedicalRecordRepository {
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	@Test
	public void test() {
		try {
			int count = medicalRecordRepository.count();
			String time = String.valueOf(System.currentTimeMillis());
			MedicalRecord medicalRecord = new MedicalRecord(time, time, time, time, time, time, time);
			medicalRecordRepository.save(medicalRecord);

			Assert.assertEquals(count, medicalRecordRepository.count());
			assertNotNull(medicalRecordRepository.findByIndex(count));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
