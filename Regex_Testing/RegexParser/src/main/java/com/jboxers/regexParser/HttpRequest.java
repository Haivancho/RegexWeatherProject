package com.jboxers.regexParser;


import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static String sendGet(String url ) throws Exception {


        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header

        con.setRequestProperty("User-Agent", USER_AGENT);

         int responseCode = con.getResponseCode();
        if(responseCode != 200){
            throw  new IllegalStateException("Expected status code:200 but got" + responseCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response.toString();

    }
}