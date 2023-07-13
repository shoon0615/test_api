package com.example.test_api.adminlte.out.domain.admin;

import com.example.test_api.adminlte.out.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Getter
@Table(name="tb_deal_d")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DealD extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long masterDealId;

    private String latestFlag;
    private String offering;
    private String deliveryPartner;
    private String deliveryPartnerGroup;
    private String salesStatus;
    private String probability;
    private String contractType;
    private String grossRevenue;
    private BigDecimal netSales;
    private LocalDate kickOffStartDate;
    private LocalDate kickOffEndDate;
    // @DateTimeFormat(pattern = "yyyy-MM")
    private YearMonth month1;
    private BigDecimal month1Amount;
    private YearMonth month2;
    private BigDecimal month2Amount;
    private YearMonth month3;
    private BigDecimal month3Amount;
    private YearMonth month4;
    private BigDecimal month4Amount;
    private YearMonth month5;
    private BigDecimal month5Amount;
    private YearMonth month6;
    private BigDecimal month6Amount;
    private YearMonth monthO;
    private BigDecimal monthOAmount;
    private String offering1;
    private String offering2;
    private String keyword;

}