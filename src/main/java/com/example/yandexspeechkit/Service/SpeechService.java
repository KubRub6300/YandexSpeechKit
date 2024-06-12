package com.example.yandexspeechkit.Service;

import com.example.yandexspeechkit.DTO.YandexRequest;
import com.example.yandexspeechkit.DTO.YandexResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.HashMap;

@Service
public class SpeechService {
    private final String URL;
    private final String API_KEY;

    WebClient client;
    YandexRequest yandexRequest;
    Gson gson;

    private final String BODY = "{     \"text\": \"Привет!\\nЯ Яндекс Спичк+ит.\\nЯ могу превратить любой текст в речь.\\nТеперь и в+ы - можете!\",     \"hints\": [         {             \"speed\": 1         },         {             \"voice\": \"marina\"         },         {             \"role\": \"neutral\"         }     ] }";

    public SpeechService(@Value("${yandex.url}") String url,
                         @Value("${yandex.api-key}") String apiKey) {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        URL = url;
        API_KEY = apiKey;
        client = WebClient.builder().baseUrl(URL).defaultHeader("Authorization", "Api-Key " + API_KEY).build();
        yandexRequest = new YandexRequest();

        yandexRequest.addHint("speed", 1);
        yandexRequest.addHint("voice", "marina");
        yandexRequest.addHint("role", "neutral");
    }

    public void getSpeech() {
        //Authorization: Api-Key <API-ключ>

        yandexRequest.setText("Привет! Это озвучка от Яндекс!");
        WebClient client = WebClient.create();

        String response = client
                .post()
                .uri(URL)
//                .uri("http://localhost:8080/speech")
                .accept( MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Api-Key " + API_KEY)
                .bodyValue(gson.toJson(yandexRequest))
                .retrieve()
                .bodyToMono(String.class).block();

        YandexResponse yandexResponse = gson.fromJson(response, YandexResponse.class);

        System.out.println(yandexResponse.toString());

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\kubar\\Music\\voice.mp3")) {
            byte[] audioData = yandexResponse.getResult().getAudioChunk().get("data").getBytes();
            fos.write(audioData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
