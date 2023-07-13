package com.example.test_api.adminlte.in.dto;

import com.example.test_api.adminlte.out.domain.admin.DealD;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter         // 제거 예정
@ToString
@NoArgsConstructor
@Schema(description = "테스트 Request",
        requiredProperties = {"title", "content"})      // swagger 필수 표시
public class AdminRequest {

    @Schema(description = "PK")
    private Long id;

    @Schema(description = "제목", example = "제목입니다.")
    private String title;

    @Schema(description = "내용", example = "내용입니다.")
    private String content;

    @Schema(description = "작성자", example = "작성자입니다.", nullable = true)
    private String author;

    @Builder
    public AdminRequest(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
