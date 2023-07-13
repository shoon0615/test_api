package com.example.test_api.util.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name="tb_common_code_m")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASTER_ID")
    private Long masterId;

    private String codeName;

}
