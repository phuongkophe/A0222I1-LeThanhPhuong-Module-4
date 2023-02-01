package com.example.phone_management.service;

import com.example.phone_management.model.SmartPhone;
import org.springframework.stereotype.Service;

@Service
public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone phone);

    SmartPhone remove(Integer id);
}
