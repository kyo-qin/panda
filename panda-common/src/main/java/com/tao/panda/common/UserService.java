package com.tao.panda.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    DataMS dataMs;

    public String getUserName() {
        return "Qintao";
    }
    
    public DataMS getDataMS() {
        return dataMs;
    }
}
