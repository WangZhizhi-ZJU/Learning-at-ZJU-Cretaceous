package com.melodic;

import com.melodic.dao.StudentDao;
import com.melodic.pojo.account.Student;
import com.melodic.service.student.StudentLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningInZjuCretaceousApplicationTests {

	@Autowired
	private StudentDao studentDao;

	@Test
	void contextLoads() {
		System.out.println(studentDao.update(new Student(
				"3200100001",
				null,
				null,
				null,
				null,
				null,
				null,
				2,
				null,
				null,
				null,
				null,
				null,
				"666"
		)));
	}
}
