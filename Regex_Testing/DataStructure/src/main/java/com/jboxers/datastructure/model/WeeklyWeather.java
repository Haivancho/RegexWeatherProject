package com.jboxers.datastructure.model;


import com.jboxers.datastructure.modelData.WeeklyWeatherData;
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
@NamedQuery(name = WeeklyWeather.FIND_ALL_WEEKND, query = "SELECT ww FROM WeeklyWeather ww")
public class WeeklyWeather extends AbstractEntity {

    public static final String FIND_ALL_WEEKND = "findAllWeekndWeather";

    @OneToMany
    @Cascade(CascadeType.ALL) //Example: If we delete One all Many will be deleted as well (dont do the reverse case)
    private List<WeeklyWeatherData> weeklyWeatherData;



    public WeeklyWeather() {
        weeklyWeatherData = new ArrayList<>();
    }

    public void addToWeeklyWeather(String airQualityIndex, String maxTemp, String minTemp,
                                   String chanceToRain, LocalDateTime dateTime) {
        weeklyWeatherData.add(new WeeklyWeatherData(airQualityIndex,maxTemp,minTemp,dateTime,chanceToRain));
    }

    public WeeklyWeather(List<WeeklyWeatherData> weeklyWeatherData) {
        this.weeklyWeatherData = weeklyWeatherData;
    }

    @Override
    public String toString() {
        return "WeeklyWeather{" +
                "weeklyWeatherData=" + weeklyWeatherData +
                '}';
    }
}
