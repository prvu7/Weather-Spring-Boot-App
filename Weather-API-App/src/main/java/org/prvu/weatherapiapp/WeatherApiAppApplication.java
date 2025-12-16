package org.prvu.weatherapiapp;

import org.prvu.weatherapiapp.model.WeatherResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApiAppApplication {

    public static void main(String[] args) {
        WeatherResponse weatherResponse = new WeatherResponse();
        
        weatherResponse.setCity("Madrid");
        weatherResponse.setDescription("Sunny");
        weatherResponse.setTemperature(25.0);
        weatherResponse.setHumidity(60.0);
        weatherResponse.setWindSpeed(10.0);

        System.out.println(weatherResponse);
    }

}
