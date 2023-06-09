package openweatherapi;
import com.mycompany.app.App;
import io.restassured.*;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetWeatherData {

    private static final Logger logger = LogManager.getLogger(GetWeatherData.class);
//method
    public static String getWeatherData(){
        /**
         * 1. Is to prepare for the call - HostName, Port Number if there is any
         *  resource name, query parameter
         * 2. Execute Call and get the response. And hold the response in a response object/container
         * 3. Validate the response as much as possible based on the requirements and manual test case
         *
         * */

        // Step 1
        String endpointUrl = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=ee0bda93f585199b7bb266bd9c30b4c8";

        // Step 2
        Response response = RestAssured.get(endpointUrl);

        // Step 3 - response --> Headers, Cookies, Status, Response Body

        String responseBody = response.getBody().asString();

        logger.info("Response Body " + responseBody);

        String base = response.path("base");
        String coord = response.path("coord.lon").toString();

        //JsonPathConfig jsonPathConfig = response.;

        // How to get coord value and base value????
        // response.getBody().jsonPath("coord");
        logger.info(base);
        logger.info(coord);
        return base;

    }
}