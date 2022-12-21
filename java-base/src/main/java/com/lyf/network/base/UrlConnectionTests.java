package com.lyf.network.base;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;

/**
 * @author liyunfei
 */
public class UrlConnectionTests {
    
    /**
     * https://blog.csdn.net/z1790424577/article/details/82938624
     * @throws IOException
     */
    @Test
    public void testApplicationProtUrl() {
        URL url = null;
        InputStream inputStream = null;

        try {
            url = new URL("http://www.baidu.com");
            URLConnection connection = url.openConnection();
            inputStream = connection.getInputStream();
            byte[]bytes = new byte[1024];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
