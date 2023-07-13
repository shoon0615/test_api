package com.example.test_api;

import com.example.test_api.adminlte.out.domain.admin.DealM;
import com.example.test_api.adminlte.out.domain.admin.DealMRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestApiApplicationTests {

	@Autowired
	private DealMRepository testRepository;

	@DisplayName("TestEntity 생성")
	@Test
	void testSave() {
		DealM test = DealM.builder().title("타이틀").topic("토픽").salesStage("판매단계").build();
		testRepository.save(test);
	}

}
