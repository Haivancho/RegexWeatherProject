package com.jboxers.datastructure.modelData;


import com.jboxers.datastructure.model.CurrentWeather;
import com.jboxers.datastructure.modelStructure.WeatherData;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name = CurrentWeatherData.FIND_ALL, query = "SELECT cw FROM CurrentWeatherData cw")
public class CurrentWeatherData extends WeatherData {

    public static final String FIND_ALL = "findAllCurrentWeatherData";

    @OneToOne
    private CurrentWeather currentWeather;

    private String currentTemp;

    public CurrentWeatherData() {
    }

    public CurrentWeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime, String currentTemp) {
        super(airQualityIndex, maxTemp, minTemp, dateTime);
        this.currentTemp = currentTemp;
    }

    @Override
    public String toString() {
        return "CurrentWeatherData{" +
                "currentWeather=" + currentWeather +
                '}';
    }
}
