/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.services.impl;

/**
 *
 * @author 2110111
 */
import edu.eci.arsw.parcial.services.HttpConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class HttpConnectionExample implements HttpConnection{

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=Q1QZFVJQ21K7C6XM";
    private ConcurrentHashMap<String, StringBuffer> cache;

    public HttpConnectionExample() {
        cache = new ConcurrentHashMap<>();
        
    }
    
    

    @Override
    public StringBuffer getDailyData(String Business) throws IOException{
        if(cache.containsKey(String.format(GET_URL,"TIME_SERIES_DAILY",Business))){
            return cache.get(String.format(GET_URL,"TIME_SERIES_DAILY",Business));
        }else{
            URL obj = new URL(String.format(GET_URL,"TIME_SERIES_DAILY",Business));
            return getData(obj);
        }
        
    }

    @Override
    public StringBuffer getWeeklyData(String Business) throws IOException{
        URL obj = new URL(String.format(GET_URL,"TIME_SERIES_WEEKLY",Business));
        return getData(obj);
    }

    @Override
    public StringBuffer getMonthlyData(String Business) throws IOException{
        URL obj = new URL(String.format(GET_URL,"TIME_SERIES_MONTHLY",Business));
        return getData(obj);
    }

    @Override
    public StringBuffer getIntradayData(String Business) throws IOException{
        URL obj = new URL(String.format(GET_URL,"TIME_SERIES_INTRADAY",Business));
        return getData(obj);
    }
    
    private StringBuffer getData(URL url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response;
        } else {
            System.out.println("GET request not worked");
            return null;
        }
    }

}
