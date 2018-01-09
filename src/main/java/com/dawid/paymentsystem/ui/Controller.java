package com.dawid.paymentsystem.ui;

import com.dawid.paymentsystem.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String get(Service service) {
        return service.getName();
    }

}
