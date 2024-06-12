package com.example.yandexspeechkit.DTO;

import java.util.Arrays;

public class AudioChunk {

    byte[] data;

    @Override
    public String toString() {
        return "AudioChunk{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
