package com.jboxers.regexParser;

import com.jboxers.datastructure.model.WeeklyWeather;
import com.jboxers.datastructure.modelData.WeeklyWeatherData;
import com.jboxers.datastructure.persistenceFascade.SaveData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeeklyWeatherParser {

    private List<String> chanceToRain;
    private List<String> minTemp;
    private List<String> maxTemp;
    private String currentTemp;
    private HttpRequest htpr = new HttpRequest();
    private ReadProperty rp = new ReadProperty();
    private List<WeeklyWeatherData> weeklyWeatherData = new ArrayList<>();

    public WeeklyWeatherParser() {
    }

    public List<WeeklyWeatherData> getWeeklyWeatherData() throws Exception {
        DataGetter dataGetter = new DataGetter();
        String html = htpr.sendGet(rp.readProperty("weekylweather.url"));

       /* String textGroups = rp.readProperty("regex.pattern.wfCurrentTemp");
        currentTemp = dataGetter.getData(textGroups, html, 2);*/

        String textGroupPattern3 = rp.readProperty("regex.pattern.probabilityForRain");
        chanceToRain = dataGetter.getData(textGroupPattern3, html, 2);

        String textGroupPattern4 = rp.readProperty("regex.pattern.minTempHourly");
        minTemp = dataGetter.getData(textGroupPattern4, html, 2);


        String textGroupPattern5 = rp.readProperty("regex.patter.maxTempHourly");
        maxTemp = dataGetter.getData(textGroupPattern5, html, 2);


        for (int i = 0; i < minTemp.size() ; i++) {

            WeeklyWeatherData  weatherData = new WeeklyWeatherData(null,
                    this.maxTemp.get(i),this.minTemp.get(i),LocalDateTime.now(), this.chanceToRain.get(i));
            weeklyWeatherData.add(weatherData);
        }

        return weeklyWeatherData;
    }


    public List<String> getChanceToRain() {
        return chanceToRain;
    }

    public List<String> getMinTemp() {
        return minTemp;
    }

    public List<String> getMaxTemp() {
        return maxTemp;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }
}


