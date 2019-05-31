package com.jboxers.regexParser;

import com.jboxers.datastructure.model.HourlyWeather;
import com.jboxers.datastructure.modelData.HourlyWeatherData;
import com.jboxers.datastructure.modelData.WeeklyWeatherData;
import com.jboxers.datastructure.persistenceFascade.SaveData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherParser {

    private List<String> howDoesTheTemperatureFeel;
    private String minTemp;
    private String maxTemp;
    private List<String> currentTemp;
    private HttpRequest htpr = new HttpRequest();
    private ReadProperty rp = new ReadProperty();
    private List<HourlyWeatherData> hourlyWeatherData = new ArrayList<>();

    public HourlyWeatherParser(){
    }


    public List<HourlyWeatherData> getHourlyWeatherData() throws Exception {
        DataGetter dataGetter = new DataGetter();

        String html = htpr.sendGet(rp.readProperty("hourlyweather.url"));

        String textGroups = rp.readProperty("regex.patttern.temp");
        currentTemp = dataGetter.getData(textGroups, html, 2);

        String textGroupPattern3 = rp.readProperty("regex.pattern.feel");
        howDoesTheTemperatureFeel = dataGetter.getData(textGroupPattern3, html, 2);

/*        String textGroupPattern4 = rp.readProperty("regex.pattern.minTemp");
        minTemp = dataGetter.getData(textGroupPattern4, html, 1);


        String textGroupPattern5 = rp.readProperty("regex.pattern.maxTemp");
        maxTemp = dataGetter.getData(textGroupPattern5, html, 2);*/

        for (int i = 0; i < currentTemp.size(); i++) {
            HourlyWeatherData weatherData = new HourlyWeatherData(this.howDoesTheTemperatureFeel.get(i),
                    null, null, LocalDateTime.now(),this.currentTemp.get(i) );
            hourlyWeatherData.add(weatherData);
        }
        return hourlyWeatherData;
    }

    public List<String> getHowDoesTheTemperatureFeel() {
        return howDoesTheTemperatureFeel;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public List<String> getCurrentTemp() {
        return currentTemp;
    }
}




