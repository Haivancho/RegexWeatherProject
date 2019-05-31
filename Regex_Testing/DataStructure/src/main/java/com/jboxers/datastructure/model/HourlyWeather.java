package com.jboxers.datastructure.model;

import com.jboxers.datastructure.modelData.HourlyWeatherData;
import com.jboxers.datastructure.modelStructure.AbstractEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = HourlyWeather.FIND_ALL_HOURLYWEATHER, query = "SELECT hw FROM HourlyWeather hw")
public class HourlyWeather extends AbstractEntity {

    public static final String FIND_ALL_HOURLYWEATHER = "findAllHourlyWeather";


    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<HourlyWeatherData> hourlyWeatherData;


    public HourlyWeather() {
        hourlyWeatherData = new ArrayList<>();
    }

    public void addHourlyWeatherData(String airQualityIndex, String maxTemp, String minTemp,
                                     String howDoesTheTemperatureFeel, LocalDateTime dateTime){
        hourlyWeatherData.add(new HourlyWeatherData(airQualityIndex,maxTemp,minTemp,dateTime,howDoesTheTemperatureFeel));
    }

    public HourlyWeather(List<HourlyWeatherData> hourlyWeatherData) {
        this.hourlyWeatherData = hourlyWeatherData;
    }

    @Override
    public String toString() {
        return "HourlyWeather{" +
                "hourlyWeatherData=" + hourlyWeatherData +
                '}';
    }
}
