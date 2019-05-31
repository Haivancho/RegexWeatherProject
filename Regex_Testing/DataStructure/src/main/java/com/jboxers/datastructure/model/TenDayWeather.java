package com.jboxers.datastructure.model;

import com.jboxers.datastructure.modelData.TenDayWeatherData;
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
@NamedQuery(name = TenDayWeather.FIND_ALL_TENDAY, query = "SELECT tw FROM TenDayWeather tw")
public class TenDayWeather extends AbstractEntity {

    public static final String FIND_ALL_TENDAY = "findAllTenDayWeather";

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<TenDayWeatherData> tenDayWeatherData;

    public TenDayWeather() {
        tenDayWeatherData = new ArrayList<>();
    }

    public void addTenDayWeatherData(String airQualityIndex, String maxTemp, String minTemp,
                                     String chanceToRain, LocalDateTime dateTime, String day) {
        tenDayWeatherData.add(new TenDayWeatherData( airQualityIndex,maxTemp,minTemp,dateTime,chanceToRain,day));
    }

    public TenDayWeather(List<TenDayWeatherData> tenDayWeatherData) {
        this.tenDayWeatherData = tenDayWeatherData;
    }

    @Override
    public String toString() {
        return "TenDayWeather{" +
                "tenDayWeatherData=" + tenDayWeatherData +
                '}';
    }
}
