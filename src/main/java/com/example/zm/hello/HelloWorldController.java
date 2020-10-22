package com.example.zm.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zm
 * @since 2020/10/22 19:13
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/world")
    public String world() {
        return "HelloWorld";
    }
}
