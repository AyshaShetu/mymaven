package com.mycompany.app;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import openweatherapi.GetWeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class GetWeatherDataTest {

    private static final Logger logger = LogManager.getLogger(GetWeatherDataTest.class);

///unit testing
    @Test
    public void getWeatherTest(){
        String actualValue =  GetWeatherData.getWeatherData();
        Assert.assertEquals("stations",actualValue);
        logger.info("Test Passed");
    }
}