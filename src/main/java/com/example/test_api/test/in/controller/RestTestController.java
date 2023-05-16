package com.example.test_api.test.in.controller;

import com.example.test_api.test.in.dto.TestRequest;
import com.example.test_api.test.in.service.TestService;
import com.example.test_api.test.out.dto.TestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@Tag(name = "TestController", description = "테스트 컨트롤러")        // name 이 같으면 api 그룹화
public class RestTestController {

    private final TestService testService;

    @GetMapping("/{id}")    // GET 은 swagger 의 parameter 에 requestBody 가 조회되지 않음
    @Operation(summary = "상세정보 조회", description = "상세정보를 조회한다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = TestResponse.class))),
            @ApiResponse(responseCode = "400", description = "실패", content = @Content(schema = @Schema(implementation = TestResponse.class))),
            @ApiResponse(responseCode = "404", description = "못찾음", content = @Content(schema = @Schema(implementation = TestResponse.class)))
    })
    public ResponseEntity getTest(
            @Parameter(name = "id", description = "posts 의 id", in = ParameterIn.PATH)
            @PathVariable final Long id) {        // @NotBlank(message = "id는 필수값 입니다.") @PathVariable Long id
        return testService.findTest(id);
    }

    @PostMapping
    @Operation(summary = "목록 조회", description = "목록을 조회한다.",
        responses = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TestResponse.class)))),
            @ApiResponse(responseCode = "400", description = "실패", content = @Content(schema = @Schema(implementation = TestResponse.class))),
            @ApiResponse(responseCode = "404", description = "못찾음", content = @Content(schema = @Schema(implementation = TestResponse.class)))
    })
    public ResponseEntity getTestList(@RequestBody final TestRequest request) {
        return testService.getTestList(request);
    }

    @PutMapping
    @Operation(summary = "저장", description = "저장한다.(추가/수정)",
        responses = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "400", description = "실패", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
            @ApiResponse(responseCode = "404", description = "못찾음", content = @Content(schema = @Schema(implementation = ResponseEntity.class)))
    })
    public ResponseEntity saveTest(@RequestBody final TestRequest request) {
        return testService.saveTest(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTest(final Long id) {
        return testService.deleteTest(id);
    }

}
