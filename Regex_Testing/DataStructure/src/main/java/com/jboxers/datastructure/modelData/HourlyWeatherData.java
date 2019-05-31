package com.jboxers.datastructure.modelData;

import com.jboxers.datastructure.model.HourlyWeather;
import com.jboxers.datastructure.modelStructure.WeatherData;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class HourlyWeatherData extends WeatherData {

    @ManyToOne
    private HourlyWeather hourlyWeather;

    private String howDoesTheTemperatureFeel;

    public HourlyWeatherData() {}

    public HourlyWeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime, String howDoesTheTemperatureFeel) {
        super(airQualityIndex, maxTemp, minTemp, dateTime);
        this.howDoesTheTemperatureFeel = howDoesTheTemperatureFeel;
    }

    @Override
    public String toString() {
        return "HourlyWeatherData{" +
                "hourlyWeather=" + hourlyWeather +
                '}';
    }
}
