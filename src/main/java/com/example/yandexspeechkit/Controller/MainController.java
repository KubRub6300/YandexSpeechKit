package com.example.yandexspeechkit.Controller;

import com.example.yandexspeechkit.Service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    SpeechService speechService;

    @GetMapping("/speech")
    public String speech(){
        speechService.getSpeech();
        return "ready";
    }

    @PostMapping("/speech")
    public String speechPost(HttpEntity<String> httpEntity){
        return "ready";
    }
}
