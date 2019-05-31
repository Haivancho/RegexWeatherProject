package com.jboxers.datastructure.modelData;

import com.jboxers.datastructure.model.TenDayWeather;
import com.jboxers.datastructure.modelStructure.WeatherData;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class TenDayWeatherData extends WeatherData {

    @ManyToOne
    private TenDayWeather tenDayWeather;

    private String chanceToRain;
    private String day;


    public TenDayWeatherData() {
    }

    public TenDayWeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime, String chanceToRain, String day) {
        super(airQualityIndex, maxTemp, minTemp, dateTime);
        this.chanceToRain = chanceToRain;
        this.day = day;
    }

    @Override
    public String toString() {
        return "TenDayWeatherData{" +
                "tenDayWeather=" + tenDayWeather +
                '}';
    }
}
