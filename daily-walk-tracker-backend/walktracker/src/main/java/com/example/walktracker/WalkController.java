package com.example.walktracker;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/walk")
@CrossOrigin(origins = "*")
public class WalkController {

    private final EmailService emailService;

    public WalkController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/status")
    public String receiveStatus(@RequestBody WalkStatusRequest request) {
        emailService.sendEmail(request.getWalkStatus());
        return "Status saved: " + request.getWalkStatus();
    }
    
    @GetMapping("/")
    public String home() {
        return "Daily Walk Tracker Backend is running!";
}


}