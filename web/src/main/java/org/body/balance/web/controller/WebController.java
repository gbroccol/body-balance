package org.body.balance.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/authenticated")
    public String authenticatedPage() {
        return "authenticated";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
}
