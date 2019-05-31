package com.jboxers.datastructure.modelData;

import com.jboxers.datastructure.modelStructure.WeatherData;
import com.jboxers.datastructure.model.WeeklyWeather;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class WeeklyWeatherData extends WeatherData {

    @ManyToOne
    private WeeklyWeather weeklyWeather;

    private String chanceToRain;

    public WeeklyWeatherData() {}

    public WeeklyWeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime, String chanceToRain) {
        super(airQualityIndex, maxTemp, minTemp, dateTime);
        this.chanceToRain = chanceToRain;
    }

    @Override
    public String toString() {
        return "WeeklyWeatherData{" +
                "weeklyWeather=" + weeklyWeather +
                '}';
    }
}
