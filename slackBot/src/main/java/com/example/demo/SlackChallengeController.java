package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class SlackChallengeController {
	@PostMapping
    private String permissionScope(@RequestBody String payload) {

        System.out.println("payload" + payload);
        int beginIndex = payload.indexOf("challenge");
        int endIndex = payload.indexOf("type");
        String challengeValue = payload.substring(beginIndex + 12, endIndex - 3);
        System.out.println("challenge value = " + challengeValue);
        return challengeValue;
    }

}
