package com.example.yandexspeechkit.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class YandexRequest {
    private String text;
    private List<Map<String,Object>> hints;
    OutputAudioSpec outputAudioSpec;

    public YandexRequest() {
        hints = new ArrayList<>();
    }

    public OutputAudioSpec getOutputAudioSpec() {
        return outputAudioSpec;
    }

    public void setOutputAudioSpec(OutputAudioSpec outputAudioSpec) {
        this.outputAudioSpec = outputAudioSpec;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Map<String, Object>> getHints() {
        return hints;
    }

    public void setHints(List<Map<String, Object>> hints) {
        this.hints = hints;
    }

    public void addHint(String key, Object value){
        Map<String, Object> entity = new HashMap<>();
        entity.put(key,value);
        hints.add(entity);
    }
}
