package com.example.myapplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlaskServer {

    private InputStream inputStream = null;
    private String result = "";

    public FlaskServer() {
    }
    // Server İşlemleri
    public String getData(String url) {

        // Bağlantı kuruluyor
        try {
            URL urlObject = new java.net.URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
            conn.setRequestMethod("GET");
            inputStream = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Serverdaki return değeri okunuyor
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String tmp = line;
                sb.append(tmp);
            }
            inputStream.close();
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Serverdaki return değeri kullanıcıya döndürülüyor
        return result;
    }
}
