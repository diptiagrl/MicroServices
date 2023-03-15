package com.citi.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8081/actuator/refresh - POST

@RefreshScope
@RestController

class MessageRestController {
 
    @Value("${msg:Hello world - Config Server is not working..pelase check}")
    private String msg;
 
    @GetMapping("/msg")
    String getMsg() {
        return this.msg;
    }

}
