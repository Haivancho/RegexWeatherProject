package com.jboxers.regexParser;

import com.jboxers.datastructure.model.FiveDayWeather;
import com.jboxers.datastructure.modelData.FiveDayWeatherData;
import com.jboxers.datastructure.modelData.WeeklyWeatherData;
import com.jboxers.datastructure.persistenceFascade.SaveData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FiveDayWeatherParser {

    private String airQualityIndex;
    private List<String> minTemp;
    private List<String> maxTemp;
    private List<String> currentTemp;
    private HttpRequest htpr = new HttpRequest();
    private ReadProperty rp = new ReadProperty();
    private List<FiveDayWeatherData> fiveDayWeatherData = new ArrayList<>();

    public FiveDayWeatherParser() {

   }

    public List<FiveDayWeatherData> getFiveDayWeatherData () throws Exception {
        fiveDayWeatherData = new ArrayList<>();
        DataGetter dataGetter = new DataGetter();

        String html = htpr.sendGet(rp.readProperty("fivedayweather.url"));

        String textGroups = rp.readProperty("regex.pattern.day");
        currentTemp = dataGetter.getData(textGroups, html, 2);

  /*      String textGroupPattern3 = rp.readProperty("regex.pattern.wfAirQualityIndex");
        airQualityIndex = dataGetter.getData(textGroupPattern3, html, 2);*/

        String textGroupPattern4 = rp.readProperty("regex.pattern.minTempFiveDay");
        minTemp = dataGetter.getData(textGroupPattern4, html, 2);


        String textGroupPattern5 = rp.readProperty("regex.pattern.maxTempFiveDay");
        maxTemp = dataGetter.getData(textGroupPattern5, html, 2);

        for (int i = 0; i < currentTemp.size(); i++) {
            FiveDayWeatherData weatherData = new FiveDayWeatherData(null,
                    this.maxTemp.get(i), this.minTemp.get(i), LocalDateTime.now(), this.currentTemp.get(i));
            fiveDayWeatherData.add(weatherData);
        }

        return fiveDayWeatherData;
    }

}


