package com.example.test_api.adminlte.out.dto;

import com.example.test_api.adminlte.out.domain.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Schema(description = "테스트 Response")
public class AdminResponse extends BaseTimeEntity {

    @Schema(description = "PK")
    private Long id;

    @Schema(description = "제목", example = "제목입니다.222")
    private String title;

    @Schema(description = "내용", example = "내용입니다.222")
    private String content;

    @Schema(description = "작성자", example = "작성자입니다.222")
    private String author;

    @Schema(description = "조회수", example = "조회수입니다.222")
    private int hits;

}
