package com.example.phone_management.service;

import com.example.phone_management.model.SmartPhone;
import com.example.phone_management.repository.SmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartPhoneServiceImpl implements SmartPhoneService{
    @Autowired
    SmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartPhoneRepository.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {

        return null;
    }
}
