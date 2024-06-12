package com.example.yandexspeechkit.DTO;

import java.util.Map;

public class Result {
    private Map<String, String> audioChunk;
    private Map<String, String> textChunk;
    private String startMs;
    private String lengthMs;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "audioChunk=" + audioChunk +
                ", textChunk=" + textChunk +
                ", startMs='" + startMs + '\'' +
                ", lengthMs='" + lengthMs + '\'' +
                '}';
    }

    public Map<String, String> getAudioChunk() {
        return audioChunk;
    }

    public void setAudioChunk(Map<String, String> audioChunk) {
        this.audioChunk = audioChunk;
    }

    public Map<String, String> getTextChunk() {
        return textChunk;
    }

    public void setTextChunk(Map<String, String> textChunk) {
        this.textChunk = textChunk;
    }

    public String getStartMs() {
        return startMs;
    }

    public void setStartMs(String startMs) {
        this.startMs = startMs;
    }

    public String getLengthMs() {
        return lengthMs;
    }

    public void setLengthMs(String lengthMs) {
        this.lengthMs = lengthMs;
    }
}
