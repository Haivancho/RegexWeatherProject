package com.jboxers.datastructure.persistenceFascade;

import com.jboxers.datastructure.model.*;

import javax.persistence.EntityManager;

public class SaveData {

    private static SaveData instance;
    private EntityManager em;

    public SaveData() {
        em = EntityManagerProducer.getEntityManager();
    }


    public CurrentWeather saveCurrentWeather(CurrentWeather currentWeather) {
        em.getTransaction().begin();

        if(currentWeather.getId() == null || currentWeather.getId() == 0) {
            em.persist(currentWeather);
        } else {
            currentWeather = em.merge(currentWeather);
        }

        em.getTransaction().commit();
        return currentWeather;
    }

    public FiveDayWeather saveFiveDayWeather(FiveDayWeather fiveDayWeather) {
        em.getTransaction().begin();

        if(fiveDayWeather.getId() == null || fiveDayWeather.getId() == 0) {
            em.persist(fiveDayWeather);
        } else {
            fiveDayWeather = em.merge(fiveDayWeather);
        }

        em.getTransaction().commit();
        return fiveDayWeather;
    }


    public HourlyWeather saveHourlyWeather(HourlyWeather hourlyWeather) {
        em.getTransaction().begin();

        if(hourlyWeather.getId() == null || hourlyWeather.getId() == 0) {
            em.persist(hourlyWeather);
        } else {
            hourlyWeather = em.merge(hourlyWeather);
        }

        em.getTransaction().commit();
        return hourlyWeather;
    }


    public TenDayWeather saveTenDayWeather(TenDayWeather tenDayWeather) {
        em.getTransaction().begin();

        if(tenDayWeather.getId() == null || tenDayWeather.getId() == 0) {
            em.persist(tenDayWeather);
        } else {
            tenDayWeather = em.merge(tenDayWeather);
        }

        em.getTransaction().commit();
        return tenDayWeather;
    }

    public WeeklyWeather saveWeeklyWeather(WeeklyWeather weeklyWeather) {
        em.getTransaction().begin();

        if(weeklyWeather.getId() == null || weeklyWeather.getId() == 0) {
            em.persist(weeklyWeather);
        } else {
            weeklyWeather = em.merge(weeklyWeather);
        }

        em.getTransaction().commit();
        return weeklyWeather;
    }


    public Forecast saveForecast(Forecast forecast) {
        em.getTransaction().begin();

        if(forecast.getId() == null || forecast.getId() == 0) {
            em.persist(forecast);
        } else {
            forecast = em.merge(forecast);
        }

        em.getTransaction().commit();
        return forecast;
    }




    public synchronized static SaveData get() {
        if(instance == null) {
            instance = new SaveData();
        }

        return instance;
    }
}
