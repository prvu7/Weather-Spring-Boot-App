package org.prvu.weatherapiapp;

import org.prvu.weatherapiapp.model.WeatherResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(WeatherService weatherService) {
        return args -> {
            Scanner scanner = new Scanner(System.in);

            System.out.println("------------------------------------------");
            System.out.println("   Welcome to the Spring Boot Weather CLI");
            System.out.println("------------------------------------------");

            while (true) {
                System.out.print("\nEnter a city name (or type 'exit' to quit): ");
                String city = scanner.nextLine();

                if ("exit".equalsIgnoreCase(city)) {
                    System.out.println("Goodbye!");
                    break;
                }

                try {
                    WeatherResponse response = weatherService.getWeather(city);

                    // Notice the usage of Getters here
                    String cityName = response.getName();
                    double temp = response.getMain().getTemp();
                    int humidity = response.getMain().getHumidity();
                    double windSpeed = response.getWind().getSpeed();

                    System.out.printf("Creating report for: %s%n", cityName);
                    System.out.printf("🌡️  Temperature: %.1f°C%n", temp);
                    System.out.printf("💧 Humidity:    %d%%%n", humidity);
                    System.out.printf("🌬️  Wind Speed:  %.1f m/s%n", windSpeed);

                } catch (Exception e) {
                    System.out.println("Error: Could not find weather data for '" + city + "'.");
                }
            }
        };
    }

}
