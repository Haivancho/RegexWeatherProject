package com.jboxers.datastructure.modelData;

import com.jboxers.datastructure.model.FiveDayWeather;
import com.jboxers.datastructure.modelStructure.WeatherData;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import java.time.LocalDateTime;

@Entity
public class FiveDayWeatherData extends WeatherData {

    @ManyToOne
    private FiveDayWeather fiveDayWeather;

    private String day;

    public FiveDayWeatherData() {
    }

    public FiveDayWeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime, String day) {
        super(airQualityIndex, maxTemp, minTemp, dateTime);
        this.day = day;
    }

    @Override
    public String toString() {
        return "FiveDayWeatherData{" +
                "fiveDayWeather=" + fiveDayWeather +
                '}';
    }
}
