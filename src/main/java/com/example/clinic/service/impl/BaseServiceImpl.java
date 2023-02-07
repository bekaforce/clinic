package com.example.clinic.service.impl;

import com.example.clinic.service.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("Asia/Bishkek"));
    }
}
