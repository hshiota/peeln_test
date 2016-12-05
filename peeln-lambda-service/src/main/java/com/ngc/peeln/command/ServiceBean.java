package com.ngc.peeln.command;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ServiceBean {
    
    private String str1 = "1";
    private String str2 = "2";;
    private String str3 = "3";;
    private String str4;
    
    private List<String> list;
    
    
    public String serviceMethod(String input) {
        return "Called serviceMethod : arg = " + input;
    }
}