package com.br.fastBurguer.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConvertToJson {

    @Autowired
    ObjectMapper objectMapper;

    public String convertPayloadToJson(Object entity) throws JsonProcessingException {
       return objectMapper.writeValueAsString(entity);
    }

    public String convertPayloadToJson(List<Object> entity) throws JsonProcessingException {
       return objectMapper.writeValueAsString(entity);
    }
}