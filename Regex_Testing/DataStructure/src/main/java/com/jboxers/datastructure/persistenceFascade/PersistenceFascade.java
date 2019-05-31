package com.jboxers.datastructure.persistenceFascade;

import com.jboxers.datastructure.model.*;
import com.jboxers.datastructure.modelData.CurrentWeatherData;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class PersistenceFascade {

    private static PersistenceFascade instance;
    private EntityManager em;

    public PersistenceFascade() {
        em = EntityManagerProducer.getEntityManager();
    }


    public List<CurrentWeather> findAll() {
        return em.createNamedQuery(CurrentWeatherData.FIND_ALL)
                .getResultList();
    }

    public List<CurrentWeather> findAll(LocalDateTime dateFrom , LocalDateTime dateTo) {
        return em.createNamedQuery(CurrentWeather.FIND_ALL_BY_DATE)
                .getResultList();
    }

    public List<Forecast> findAllForecast(){
        return em.createNamedQuery(Forecast.FIND_ALL_FORECAST).getResultList();
    }

    public  List<FiveDayWeather> findALLFiveDayWeather(){
        return em.createNamedQuery(FiveDayWeather.FIND_ALL_FIVEDAY).getResultList();
    }

    public List<HourlyWeather> findAllHourlyWeather() {
        return em.createNamedQuery(HourlyWeather.FIND_ALL_HOURLYWEATHER).getResultList();
    }


    public List<TenDayWeather> findAllTenDayWeather() {
        return em.createNamedQuery(TenDayWeather.FIND_ALL_TENDAY).getResultList();
    }

    public List<WeeklyWeather> findAllWeekendWeather(){
        return em.createNamedQuery(WeeklyWeather.FIND_ALL_WEEKND).getResultList();
    }



    public synchronized static PersistenceFascade get() {
        if(instance == null) {
            instance = new PersistenceFascade();
        }

        return instance;
    }

}
