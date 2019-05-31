package com.jboxers.datastructure.modelStructure;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public abstract class WeatherData extends AbstractEntity {


    private String airQualityIndex;
    private String maxTemp;
    private String minTemp;
    public LocalDateTime dateTime;

    public WeatherData() {
    }


    public WeatherData(String airQualityIndex, String maxTemp, String minTemp, LocalDateTime dateTime) {
        this.airQualityIndex = airQualityIndex;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }


    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(String airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }



}