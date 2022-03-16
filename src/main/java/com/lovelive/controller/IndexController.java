package com.lovelive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 太好听了吧
 * @version 1.0
 * @Description TODO
 * @Date 2022/3/16 13:09
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }
}
