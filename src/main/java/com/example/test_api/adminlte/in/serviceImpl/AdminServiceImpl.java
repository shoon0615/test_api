package com.example.test_api.adminlte.in.serviceImpl;

import com.example.test_api.adminlte.in.dto.AdminRequest;
import com.example.test_api.adminlte.in.service.AdminService;
import com.example.test_api.adminlte.out.domain.admin.*;
import com.example.test_api.adminlte.out.dto.AdminResponse;
import com.example.test_api.adminlte.out.dto.CommonResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final DealMRepository dealMRepository;
    private final DealDRepository dealDRepository;
    private final CommonRepository commonRepository;
    private final ObjectMapper mapper;

    @Transactional
    @Override
    public ResponseEntity findTest(Long id) {
        DealM dealM = dealMRepository.findById(id).orElse(null);
        return ResponseEntity.ok(dealM);
    }

    @Transactional
    @Override
    public ResponseEntity findAllTest(AdminRequest request) {
        return ResponseEntity.ok(null);
    }

    @Transactional
    @Override
    public ResponseEntity saveTest(AdminRequest request) {
        return ResponseEntity.ok(null);
    }

    @Transactional
    @Override
    public ResponseEntity deleteTest(Long id) {
        return ResponseEntity.ok(null);
    }

    @Transactional
    @Override
    public ResponseEntity findAllCommon() {
        List<Map<String, Object>> entity = commonRepository.findAllCommon();
        // List<CommonResponse> cs = mapper.convertValue(entity, new TypeReference<>() {});
        List<CommonResponse> cs = entity.stream()
                .map(e -> CommonResponse.builder()
                        .codeName(String.valueOf(e.get("CODE_NAME")))
                        .label(String.valueOf(e.get("LABEL")))
                        .value(String.valueOf(e.get("VALUE")))
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(cs);
    }

}
