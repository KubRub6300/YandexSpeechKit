package com.example.yandexspeechkit.DTO;

import java.util.Map;
import java.util.Objects;

public class YandexResponse {
    Result result;

    public YandexResponse() {
    }

    @Override
    public String toString() {
        return "YandexResponse{" +
                "result=" + result +
                '}';
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}


