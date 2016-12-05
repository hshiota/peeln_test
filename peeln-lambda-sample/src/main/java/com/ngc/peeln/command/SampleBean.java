package com.ngc.peeln.command;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SampleBean {
    
    private String str1 = "1";
    private String str2 = "2";;
    private String str3 = "3";;
    private String str4;
    
    private List<String> list;
    
    
    public String sampleMethod(String input) {
        return "Called sampleMethod : arg = " + input;
    }
}