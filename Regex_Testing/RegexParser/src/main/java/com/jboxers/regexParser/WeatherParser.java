package com.jboxers.regexParser;

import com.jboxers.datastructure.model.*;
import com.jboxers.datastructure.persistenceFascade.PersistenceFascade;
import com.jboxers.datastructure.persistenceFascade.SaveData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class WeatherParser {
    private static final Logger logger = LogManager.getLogger(Class.class.getName());

    public static void parseAndSaveWeather() throws Exception {
        CurrentWeatherParser cwP = new CurrentWeatherParser();
        WeeklyWeatherParser wwP = new WeeklyWeatherParser();
        FiveDayWeatherParser fdP = new FiveDayWeatherParser();
        HourlyWeatherParser hwP = new HourlyWeatherParser();
        TenDayWeatherParser tdwP = new TenDayWeatherParser();

        SaveData saveData = new SaveData();


        FiveDayWeather fiveDayWeather = new FiveDayWeather(fdP.getFiveDayWeatherData());
        HourlyWeather hourlyWeather = new HourlyWeather(hwP.getHourlyWeatherData());
        TenDayWeather tenDayWeather = new TenDayWeather(tdwP.getTenDayWeatherData());
        WeeklyWeather weeklyWeather = new WeeklyWeather(wwP.getWeeklyWeatherData());
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.addCurrentWeatherData(cwP.getAirQualityIndex(),cwP.getMaxTemp(),cwP.getMinTemp(),cwP.getCurrentTemp(),LocalDateTime.now());

        Forecast forecast = new Forecast(currentWeather,hourlyWeather,weeklyWeather,tenDayWeather,fiveDayWeather);

        saveData.saveFiveDayWeather(fiveDayWeather);
        saveData.saveHourlyWeather(hourlyWeather);
        saveData.saveTenDayWeather(tenDayWeather);
        saveData.saveWeeklyWeather(weeklyWeather);
        saveData.saveCurrentWeather(currentWeather);
        saveData.saveForecast(forecast);


        logger.log(Level.INFO,"Starting thread...");
        logger.log(Level.INFO,"Thread started at:" + LocalDateTime.now());


        PersistenceFascade persistenceFascade = new PersistenceFascade();

       persistenceFascade.findAllForecast().forEach(f -> System.out.println(f.toString()));


    }
}



/*        Forecast forecast = new Forecast(client,null,null);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Forecast());
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

        entityManager.getTransaction().begin();

        entityManager.persist(client);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();

        List<CurrentWeatherData> all = PersistenceFascade.get().findAll();
        System.out.println(all.size());*/