package com.example.test_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing			// 트랜잭션 커밋 시점에 flush 때 Auditing 기능 실행
@SpringBootApplication
public class TestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

	// chrome 은 모든 매핑을 지원하지만 GET/POST 만 지원하는 브라우저는 method 따로 받아야함(PUT/DELETE..) -> axios 는 상관없음
	// form 기준: <input type="hidden" name="_method" value="put" />
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

}
