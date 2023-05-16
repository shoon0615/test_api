package com.example.test_api.test.in.serviceImpl;

import com.example.test_api.test.in.dto.TestRequest;
import com.example.test_api.test.in.service.TestService;
import com.example.test_api.test.out.domain.test.TestEntity;
import com.example.test_api.test.out.domain.test.TestRepository;
import com.example.test_api.test.out.dto.TestResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    // inDto 를 outDto 로 convert -> outDto = mapper.convertValue(inDto, new TypeReference<>() {});
    private final ObjectMapper mapper;              // 단, inDto 를 entity 로 convert 해도 영속성 적용 안 됨
    private final TestRepository testRepository;

    @Transactional
    @Override
    public ResponseEntity findTest(Long id) {
        // id 를 못찾은 경우 null 로 return
        // testEntity test = testRepository.findById(id).orElse(null);
        // id 를 못찾은 경우 exception 발생
        // testEntity test = testRepository.findById(id).orElseThrow(() -> new Exception());
        TestEntity test = testRepository.findById(id).get();
        test.increaseHits();       // JPA 영속성 컨텍스트로 인해 기존 값이 변경되면 자동 update
        TestResponse outDto = mapper.convertValue(test, new TypeReference<>() {});
        return ResponseEntity.ok(outDto);
    }

    @Transactional
    @Override
    public ResponseEntity getTestList(TestRequest request) {
        List<TestEntity> testList = testRepository.findAll();
        List<TestResponse> outDtoList = mapper.convertValue(testList, new TypeReference<>() {});

        /*List<TestResponse> outDtoList = new ArrayList<>();
        for(TestEntity test : testList) {
            TestResponse outDto = TestResponse.builder()
                    .id(test.getId())
                    .title(test.getTitle())
                    .author(test.getAuthor())
                    .content(test.getContent())
                    .build();
            outDtoList.add(outDto);
        }*/

        return ResponseEntity.ok(outDtoList);
    }

    @Transactional
    @Override
    public ResponseEntity saveTest(TestRequest request) {
        Long result = testRepository.save(request.toEntity()).getId();
        return ResponseEntity.ok(result);
    }

    // update 및 save 로직이 없으나 해당 메소드가 완료(commit)되면 자동으로 update 쿼리 실행
    // JPA 는 영속성에 보관된 Entity 를 기준잡아 자동으로 쿼리가 실행되는데 해당 개념을 변경 감지(Dirty Checking) 라 한다.
    // 영속성에 없는 경우 insert(JPA save 필요), 변경된 경우 update(JPA 없어도 영속성 기준으로 자동실행) 를 실행
    @Transactional
    private Long updateTest(final TestRequest request) {
        TestEntity test = testRepository.findById(request.getId()).get();
        test.update(request.getTitle(), request.getContent(), request.getAuthor());
        return test.getId();
    }

    @Transactional
    @Override
    public ResponseEntity deleteTest(Long id) {
        testRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
