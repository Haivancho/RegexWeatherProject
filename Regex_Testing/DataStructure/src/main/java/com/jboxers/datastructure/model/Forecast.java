package com.jboxers.datastructure.model;

import com.jboxers.datastructure.modelStructure.AbstractEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = Forecast.FIND_ALL_FORECAST, query = "select fr from Forecast fr")
public class Forecast extends AbstractEntity {

    public static final String FIND_ALL_FORECAST = "findAllForecast";


    @OneToOne
    @Cascade(CascadeType.ALL)
    private CurrentWeather currentWeather;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private HourlyWeather hourlyWeather;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private WeeklyWeather weeklyWeather;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private TenDayWeather tenDayWeather;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private FiveDayWeather fiveDayWeather;


    public Forecast() {
    }


    public Forecast(CurrentWeather currentWeather, HourlyWeather hourlyWeather, WeeklyWeather weeklyWeather, TenDayWeather tenDayWeather, FiveDayWeather fiveDayWeather) {
        this.currentWeather = currentWeather;
        this.hourlyWeather = hourlyWeather;
        this.weeklyWeather = weeklyWeather;
        this.tenDayWeather = tenDayWeather;
        this.fiveDayWeather = fiveDayWeather;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public HourlyWeather getHourlyWeather() {
        return hourlyWeather;
    }

    public void setHourlyWeather(HourlyWeather hourlyWeather) {
        this.hourlyWeather = hourlyWeather;
    }

    public WeeklyWeather getWeeklyWeather() {
        return weeklyWeather;
    }

    public void setWeeklyWeather(WeeklyWeather weeklyWeather) {
        this.weeklyWeather = weeklyWeather;
    }


    @Override
    public String toString() {
        return "Forecast{" +
                "  currentWeather=" + currentWeather.toString() +
                ", hourlyWeather=" + hourlyWeather.toString() +
                ", weeklyWeather=" + weeklyWeather.toString() +
                ", tenDayWeather=" + tenDayWeather.toString() +
                ", fiveDayWeather=" + fiveDayWeather.toString() +
                '}';
    }
}
