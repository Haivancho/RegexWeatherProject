package com.jboxers.regexParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrentWeatherParser {
    private String airQualityIndex;
    private String minTemp;
    private String maxTemp;
    private String currentTemp;
    private HttpRequest htpr = new HttpRequest();
    private ReadProperty rp = new ReadProperty();


    public CurrentWeatherParser() throws Exception {

        String html = htpr.sendGet(rp.readProperty("weather.url"));

        String textGroups = rp.readProperty("regex.pattern.wfCurrentTemp");
        currentTemp = getData(textGroups, html, 2);

        String textGroupPattern3 = rp.readProperty("regex.pattern.wfAirQualityIndex");
        airQualityIndex = getData(textGroupPattern3, html, 2);

        String textGroupPattern4 = rp.readProperty("regex.pattern.minTemp");
        minTemp =getData(textGroupPattern4, html, 1);


        String textGroupPattern5 = rp.readProperty("regex.pattern.maxTemp");
        maxTemp = getData(textGroupPattern5, html, 2);
    }


    public String getData(String pattern, String html, int group) {
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(html);

        String result = "";
        if (matcher.find()) {
            result = matcher.group(group);

            System.out.println("Occurrences: " + result);


            System.out.println("This is saved now: " + result);
        }

        return result;
    }


    public String getAirQualityIndex() {
        return airQualityIndex;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }
}
