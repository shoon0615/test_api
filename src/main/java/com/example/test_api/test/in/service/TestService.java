package com.example.test_api.test.in.service;

import com.example.test_api.test.in.dto.TestRequest;
import org.springframework.http.ResponseEntity;

public interface TestService {

    /* 단건 조회 */
    ResponseEntity findTest(Long id);

    /* 리스트 조회 */
    ResponseEntity getTestList(TestRequest request);

    /* 입력/저장 */
    ResponseEntity saveTest(TestRequest request);

    /* 삭제 */
    ResponseEntity deleteTest(Long id);

}
