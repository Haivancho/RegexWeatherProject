package com.jboxers.regexParser;

import com.jboxers.datastructure.model.TenDayWeather;
import com.jboxers.datastructure.model.WeeklyWeather;
import com.jboxers.datastructure.modelData.TenDayWeatherData;
import com.jboxers.datastructure.modelData.WeeklyWeatherData;
import com.jboxers.datastructure.persistenceFascade.SaveData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TenDayWeatherParser {


    private List<String> chanceToRain;
    private List<String> minTemp;
    private List<String> maxTemp;
    private List<String> day;
    private HttpRequest htpr = new HttpRequest();
    private ReadProperty rp = new ReadProperty();
    private List<TenDayWeatherData> tenDayWeatherData = new ArrayList<>();


    public TenDayWeatherParser(){
    }

    public List<TenDayWeatherData> getTenDayWeatherData() throws Exception {
        DataGetter dataGetter = new DataGetter();
        String html = htpr.sendGet(rp.readProperty("tendayweather.url"));

        String textGroups = rp.readProperty("regex.pattern.dayTen");
        day = dataGetter.getData(textGroups, html, 2);

        String textGroupPattern3 = rp.readProperty("regex.pattern.chanceToRain");
        chanceToRain = dataGetter.getData(textGroupPattern3, html, 2);

        String textGroupPattern4 = rp.readProperty("regex,pattern.minTempTenDays");
        minTemp = dataGetter.getData(textGroupPattern4, html, 2);


        String textGroupPattern5 = rp.readProperty("regex.pattern.maxTempTenDays");
        maxTemp = dataGetter.getData(textGroupPattern5, html, 2);

        for (int i = 0; i < chanceToRain.size() ; i++) {
            TenDayWeatherData weatherData = new TenDayWeatherData(null,
                    this.maxTemp.get(i),this.minTemp.get(i),LocalDateTime.now(),this.chanceToRain.get(i),this.day.get(i) );
            tenDayWeatherData.add(weatherData);
        }

        return tenDayWeatherData;
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

    public List<String> getDay() {
        return day;
    }
}


