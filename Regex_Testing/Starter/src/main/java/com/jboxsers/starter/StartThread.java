package com.jboxsers.starter;


import com.jboxers.regexParser.WeatherParser;

import java.util.concurrent.TimeUnit;

public class StartThread implements Runnable {

    @Override
    public void run() {

        while (true) {
            try {
                WeatherParser.parseAndSaveWeather();
                TimeUnit.HOURS.sleep(1);
            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }


}
