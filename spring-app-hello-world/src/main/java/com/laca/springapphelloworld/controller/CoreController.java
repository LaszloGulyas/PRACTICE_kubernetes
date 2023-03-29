package com.laca.springapphelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/core")
public class CoreController {

    @Value("${PRINT_TEXT:default}")
    private String textToPrint;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        StringBuilder responseBody = new StringBuilder()
          .append("Hello World!").append("\n")
          .append("Value of PRINT_TEXT: ").append(textToPrint);
        return ResponseEntity.ok(responseBody.toString());
    }

}
