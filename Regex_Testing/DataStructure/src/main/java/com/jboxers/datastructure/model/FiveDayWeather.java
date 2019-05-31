package com.jboxers.datastructure.model;

import com.jboxers.datastructure.modelData.FiveDayWeatherData;
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
@NamedQuery(name = FiveDayWeather.FIND_ALL_FIVEDAY, query = "SELECT fd FROM FiveDayWeather fd")
public class FiveDayWeather extends AbstractEntity {

    public static final String FIND_ALL_FIVEDAY = "findAllFiveDayWeather";

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<FiveDayWeatherData> fiveDayWeatherData;


    public FiveDayWeather() {
        fiveDayWeatherData = new ArrayList<>();
    }

    public void addFiveDayWeatherData(String airQualityIndex, String maxTemp, String minTemp,
                                      String day, LocalDateTime dateTime) {
        fiveDayWeatherData.add(new FiveDayWeatherData(airQualityIndex,maxTemp,minTemp,dateTime,day));
    }

    public FiveDayWeather(List<FiveDayWeatherData> fiveDayWeatherData) {
        this.fiveDayWeatherData = fiveDayWeatherData;
    }

    @Override
    public String toString() {
        return "FiveDayWeather{" +
                "fiveDayWeatherData=" + fiveDayWeatherData +
                '}';
    }
}
