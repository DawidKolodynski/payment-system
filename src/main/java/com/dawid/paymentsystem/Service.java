package com.dawid.paymentsystem;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@ResponseBody
public class Service {
    public String getName() {
        return "Dawid";
    }
}
