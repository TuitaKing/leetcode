package com.tuitaking.tree;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
    public static void main(String[] args) {
        for(int i = 0 ; i< 5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    createConn();
                }
            }).start();
        }
    }
    public static void createConn(){
        try {
            URL url=new URL("http://www.tianshouzhi.com/api/tutorials/netty/406");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
            Thread.sleep(1000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
