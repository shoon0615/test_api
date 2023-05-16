package com.example.test_api.test.out.domain.test;

import com.example.test_api.test.out.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name="TEST")             // 만들어낼 테이블명(default: 클래스명) -> Snake Case 로 name 작명해야함
// @DynamicUpdate               // 변경한 필드만 대응
@Entity
// 기본 생성자(access: 생성자의 접근 권한, protected: Entity 생성이 외부에서 불가능) = protected Test() {}와 동일
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestEntity extends BaseTimeEntity {

    @Id                                                     // = Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 자동으로 PK 1씩 증가
    private Long id;

    @Column(length = 500, nullable = false)                 // VARCHAR(500) 형식, Not Null
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    // TEXT 형식(길이 제한 없음)
    private String content;

    private String author;                                  // @Column 어노테이션 안붙일 경우 default 로 변수명 적용

    private int hits;

    @Builder
    public TestEntity(Long id, String title, String content, String author, int hits, Long fileId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.hits = hits;
    }

    // update 테스트
    public void update(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 조회 수 증가
    public void increaseHits() {
        this.hits++;
    }

}