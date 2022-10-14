package com.codegym.service;

import com.codegym.model.EmailBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailServiceImpl implements EmailService {
    private static List<EmailBox> emailBoxList = new ArrayList<>();
    @Override
    public void save(EmailBox emailBox) {
        emailBoxList.add(emailBox);
    }

    @Override
    public EmailBox getEmailConfig(String language) {
        for (EmailBox emailBox : emailBoxList) {
            if (emailBox.getLanguage().equals(language)) {
                return emailBox;
            }
        }
        return null;
    }
}
