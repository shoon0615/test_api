package com.example.test_api.util.domain;

import com.example.test_api.util.converter.BooleanToYnConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name="tb_common_code_d")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(MasterId.class)
public class CommonD {

    @Id
    private Long masterId;

    @MapsId("masterId")
    @ManyToOne
    @JoinColumn(name = "masterId", nullable = false)
    private CommonM commonM;

    @Id
    private String code;

    private String value;
    private String valueDesc;
    private String parentCode;

    @Convert(converter = BooleanToYnConverter.class)
    private Boolean usedYN;

    private Integer displayOrder;

}
