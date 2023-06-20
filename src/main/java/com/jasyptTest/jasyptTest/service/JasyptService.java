package com.jasyptTest.jasyptTest.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JasyptService {

    @Value(value = "${jasypt.key}")
    private String key;

    public String encoder(String str) {
        try {
            StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();

            jasypt.setPassword(key);
            jasypt.setAlgorithm("PBEWithMD5AndDES");
            str = jasypt.encrypt(str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "실패";
        }

    }

    public String decoder(String str) {
        try {
            StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();

            jasypt.setPassword(key);
            jasypt.setAlgorithm("PBEWithMD5AndDES");
            str = jasypt.decrypt(str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "실패";
        }

    }
}
