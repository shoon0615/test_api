package com.example.test_api.util.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MasterId implements Serializable {
    // @Column(name = "MASTER_ID")
    private Long masterId;
    @Column(nullable=false)
    private String code;
}