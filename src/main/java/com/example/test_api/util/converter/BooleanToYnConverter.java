package com.example.test_api.util.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToYnConverter implements AttributeConverter<Boolean,String> {
    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute!=null&&attribute) ? "Y":"N";
    }
}
