package com.inmotion.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eratakumi on 2017/07/01.
 */
public class CompletableFutureSample {

    public String blockingReadPage(URL url){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))){
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getLinks(String page){
        Pattern p = Pattern.compile("https?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+");
        Matcher m = p.matcher(page);
        List<String> urls = new ArrayList<>();
        if(m.find()){
            for(int i = 0;i < m.groupCount(); i++){
                urls.add(m.group(i));
            }
        }
        return urls;
    }

    public CompletableFuture<String> supplyAsync(URL url){
        return CompletableFuture.supplyAsync(() -> blockingReadPage(url));
    }

    public CompletableFuture<List<String>> thenApply(URL url){
        return CompletableFuture.supplyAsync(() -> blockingReadPage(url))
                .thenApply(CompletableFutureSample::getLinks);
    }

    public void thenAccept(URL url){
        CompletableFuture.supplyAsync(() -> blockingReadPage(url))
                .thenApply(CompletableFutureSample::getLinks)
                .thenAccept(System.out::println);
    }

}
