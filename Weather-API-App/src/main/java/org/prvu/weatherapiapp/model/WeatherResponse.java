package org.prvu.weatherapiapp.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private String cityName;
    private MainData main;
    private WindData wind;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainData {
        private double temp;
        private double humidity;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WindData {
        private double speed;
    }
}
