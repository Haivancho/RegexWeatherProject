package com.jboxers.datastructure.model;

import com.jboxers.datastructure.modelData.CurrentWeatherData;
import com.jboxers.datastructure.modelData.FiveDayWeatherData;
import com.jboxers.datastructure.modelStructure.AbstractEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name = CurrentWeather.FIND_ALL, query = "SELECT cw FROM CurrentWeather cw")
@NamedQuery(name = CurrentWeather.FIND_ALL_BY_DATE, query = "SELECT cw from CurrentWeather cw LEFT JOIN CurrentWeatherData cwd  WHERE cwd.dateTime >= :dateFrom AND cwd.dateTime <= :dateTo")
public class CurrentWeather extends AbstractEntity {

    public static final String FIND_ALL = "findAllCurrentWeather";
    public static final String FIND_ALL_BY_DATE = "findAllByDate";

    @OneToOne
    @Cascade(CascadeType.ALL)
    private CurrentWeatherData currentWeatherData;




    public CurrentWeather() {}

    public void addCurrentWeatherData(String airQualityIndex, String maxTemp, String minTemp,
                                      String currentTemp, LocalDateTime dateTime) {
        currentWeatherData = new CurrentWeatherData(airQualityIndex,maxTemp,minTemp,LocalDateTime.now(),currentTemp);
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "currentWeatherData=" + currentWeatherData +
                '}';
    }
}
