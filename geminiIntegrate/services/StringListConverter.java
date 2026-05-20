package com.geminiIntegrate.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter
    public class StringListConverter implements AttributeConverter<List<String>, String> {
        private static final ObjectMapper objectMapper = new ObjectMapper();
        @Override
        public String convertToDatabaseColumn(List<String> list) {
            if (list == null || list.isEmpty()) return "[]";
            try {
                return objectMapper.writeValueAsString(list);
            } catch (Exception e) {
                return "[]";
            }
        }

        @Override
        public List<String> convertToEntityAttribute(String json) {
            if (json == null || json.isBlank()) return new ArrayList<>();
            try {
                return objectMapper.readValue(json,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
            } catch (Exception e) {
                return new ArrayList<>();
            }
        }
    }

