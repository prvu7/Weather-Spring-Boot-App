package org.prvu.weatherapiapp.services;

import lombok.Value;
import org.prvu.weatherapiapp.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final String apiKey;

    public WeatherService(@Value("${weather.api.key}") String apiKey) {
        this.restClient = RestClient.create();
        this.apiKey = apiKey;
    }

    public WeatherResponse getWeather(String city) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();
        return restClient.get()
                .uri(url)
                .retrieve()
                .body(WeatherResponse.class);


}

