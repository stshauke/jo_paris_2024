package com.jo_paris_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StripeRedirectController {

    @GetMapping("/success")
    public String paymentSuccess() {
        return "success";
    }

    @GetMapping("/cancel")
    public String paymentCancel() {
        return "cancel";
    }
}
