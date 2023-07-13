package com.example.test_api.adminlte.in.service;

import com.example.test_api.adminlte.in.dto.AdminRequest;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    /* 단건 조회 */
    ResponseEntity findTest(Long id);

    /* 리스트 조회 */
    ResponseEntity findAllTest(AdminRequest request);

    /* 입력/저장 */
    ResponseEntity saveTest(AdminRequest request);

    /* 삭제 */
    ResponseEntity deleteTest(Long id);

    ResponseEntity findAllCommon();

}
