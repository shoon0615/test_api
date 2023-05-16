package com.example.test_api;

import com.example.test_api.test.in.dto.TestRequest;
import com.example.test_api.test.in.service.TestService;
import com.example.test_api.test.out.domain.test.TestEntity;
import com.example.test_api.test.out.domain.test.TestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TestEntityApiApplicationTests {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private TestService testService;

	@DisplayName("TestEntity 생성")
	@Test
	void testSave() {
		TestEntity test = TestEntity.builder()
				.title("제목1")
				.content("내용1")
				.author("작성자1")
				.build();
		testRepository.save(test);
	}

	@DisplayName("TestEntityList 생성")
	@Test
	void testsSave() {
		List<TestEntity> testList = new ArrayList<>();
		TestEntity test = TestEntity.builder()
				.title("제목2")
				.content("내용2")
				.author("작성자2")
				.build();
		testList.add(test);

		test = TestEntity.builder()
				.title("제목3")
				.content("내용3")
				.author("작성자3")
				.build();
		testList.add(test);

		test = TestEntity.builder()
				.title("제목4")
				.content("내용4")
				.author("작성자4")
				.build();
		testList.add(test);
		testRepository.saveAll(testList);
	}

	@DisplayName("TestService 로 생성")
	@Test
	void testService() {
		TestRequest test = TestRequest.builder()
				.title("제목9")
				.content("내용9")
				.author("작성자9")
				.build();
		testService.saveTest(test);
	}

}
