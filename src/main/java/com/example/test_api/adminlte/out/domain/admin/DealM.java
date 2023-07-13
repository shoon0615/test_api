package com.example.test_api.adminlte.out.domain.admin;

import com.example.test_api.adminlte.out.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Table(name="tb_deal_m")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DealM extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    private String title;
    private String topic;
    private String salesStage;
    private LocalDate decisionDate;
    private String currency;
    private String clientCode;
    private String endClientCode;
    private String service;
    private String digital;
    private String leadPartner;
    private String leadPartnerGroup;
    private String supportPartner1;
    private String supportPartnerGroup1;
    private String supportPartner2;
    private String supportPartnerGroup2;
    private String supportPartner3;
    private String supportPartnerGroup3;
    private String supportPartner4;
    private String supportPartnerGroup4;
    private String keyMilestone;
    private String issue;
    private String actionItem;
    private String competitor;
    private String supportPrincipal;
    private String supportPrincipalGroup;
    private String subIndustry;
    private String dropReason;

    @Builder
    public DealM(String title, String topic, String salesStage) {
        this.title = title;
        this.topic = topic;
        this.salesStage = salesStage;
    }

}