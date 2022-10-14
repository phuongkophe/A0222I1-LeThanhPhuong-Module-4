package com.codegym.service;

import com.codegym.model.EmailBox;

import java.util.List;

public interface EmailService {
//    List<EmailBox> findAll();
    void save(EmailBox emailBox);
    EmailBox getEmailConfig(String language);
}
