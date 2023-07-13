package com.example.test_api.adminlte.out.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class CommonResponse {

    private String codeName;
    private String label;
    private String value;

}
