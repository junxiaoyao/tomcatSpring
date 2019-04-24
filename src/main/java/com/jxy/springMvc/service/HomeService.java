package com.jxy.springMvc.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class HomeService {
    public String say(){
        return "i say hello at"+ Calendar.getInstance().getTime();
    }
}
