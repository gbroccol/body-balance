package org.body.balance.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/authenticated")
    public String authenticatedPage() {
        return "authenticated";
    }
}
