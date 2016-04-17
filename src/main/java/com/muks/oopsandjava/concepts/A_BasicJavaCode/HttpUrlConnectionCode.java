package com.muks.oopsandjava.concepts.A_BasicJavaCode;

import org.apache.commons.validator.UrlValidator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mukthar.ahmed on 4/15/16.
 */
public class HttpUrlConnectionCode {
    public static void main(String[] args) {
        String url = "http://www.inmobi.com";
        String image = "http://feelgrafix.com/data/images/images-15.jpg";

        new HttpUrlConnectionCode().UrlBrowser(image);
    }
    
    
    public void UrlBrowser(String inUrl) {
        UrlValidator urlValidator = new UrlValidator();
        if (urlValidator.isValid(inUrl)) {
            System.out.println("# Valid Url = " + inUrl);
        }

        try {
            HttpURLConnection httpUrlConnection = (HttpURLConnection) new URL(inUrl).openConnection();
            httpUrlConnection.setConnectTimeout(2000);
            httpUrlConnection.setRequestMethod("GET");

            System.out.println("# Response Code: " + httpUrlConnection.getResponseCode()
            + "\n# Content-Type: " + httpUrlConnection.getContentType()
            + "\n# Content-Length: " + httpUrlConnection.getContentLength() );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
