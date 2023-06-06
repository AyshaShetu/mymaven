package com.mycompany.app;

/* Make  post call - use this tutorial https://devqa.io/rest-assured-api-requests-examples/#:~:text=To%20send%20a%20POST%20request%20in%20REST%2Dassured%2C%20we%20use%20the%20post()%20method%3A
  curl --location 'https://5x9m5ed0tj.execute-api.us-east-1.amazonaws.com/test/submit' \
--header 'Authorization: Bearer eyJraWQiOiJtNlhhM3FkczlxY2o2ODZYOVBRb0JqTEJSQU5yMzBPZ21ZQzdvdThZc1N3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxdTVpbzR2YTlzcjQ1bjc5ZmNlZzJkYW1qZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiaXphYW5fdGVzdFwvcG9zdF9pbmZvIiwiYXV0aF90aW1lIjoxNjczNzIzMTI4LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9ZN3k4cTVDMVoiLCJleHAiOjE2NzM3MjY3MjgsImlhdCI6MTY3MzcyMzEyOCwidmVyc2lvbiI6MiwianRpIjoiNzQ2NWYyMGItM2VlZS00ODgzLThjMTUtM2YyM2ZhYjI2MTc4IiwiY2xpZW50X2lkIjoiMXU1aW80dmE5c3I0NW43OWZjZWcyZGFtamYifQ.HX8ntkB6yh9EHNyWRIB-UuKkza9T-9w3GxseQtxGbkC7q1MD2sum-0IZGgRiLSiBZy8Ays2LTPuGZzqXueK4besAhA_WwIT1rWOP07LexDkI5YBuDQew3yI-gGavSPQIldPGE8jlm_vSs-8im298fXvgIdHD0I-BWGq1tDb-Lwoi0GEeyPjXRxWfrLaAPGnW_tNJNRkPYjJJ6uUvxFsw3DpEgUYnzaDz5ekM6hOWgdaCH_hA6inxyDFAJFwdUgL5VawGtTHzLvFaVYF40AefDMQLWkp1m0-2keFNseZFCBzlzBsdhGQca9Y7vI4ZbJE4CqB3v1aoAxSzT8hCFEe6cw' \
--header 'Content-Type: application/json' \
--data '{
  "name" : "John",
  "age" : 10
}'
    *
    * */
import io.restassured.response.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest {
    private static final Logger logger = LogManager.getLogger(GetTokenTest.class);

    @Test
    public void postRequest() {
        String requestBody = "{\n" +             // this is how JSON key value for Body is convenient to put
                "  \"name\": \"John\",\n" +      // local variable is a variable that is declared inside a method or block of code.
                "  \"age\": 10 \n" +            // . It can only be accessed within that method or block of code
                "  }";

        String url = "https://5x9m5ed0tj.execute-api.us-east-1.amazonaws.com/test/submit";
        Response response = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer eyJraWQiOiJtNlhhM3FkczlxY2o2ODZYOVBRb0JqTEJSQU5yMzBPZ21ZQzdvdThZc1N3PSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxdTVpbzR2YTlzcjQ1bjc5ZmNlZzJkYW1qZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiaXphYW5fdGVzdFwvcG9zdF9pbmZvIiwiYXV0aF90aW1lIjoxNjg1OTk3OTEzLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAudXMtZWFzdC0xLmFtYXpvbmF3cy5jb21cL3VzLWVhc3QtMV9ZN3k4cTVDMVoiLCJleHAiOjE2ODYwMDE1MTMsImlhdCI6MTY4NTk5NzkxMywidmVyc2lvbiI6MiwianRpIjoiMmU2ZThhZGItY2IxYy00NjVmLWIzMzUtMWM2NmY5Yjc2YzE4IiwiY2xpZW50X2lkIjoiMXU1aW80dmE5c3I0NW43OWZjZWcyZGFtamYifQ.JE9gbgS27vLY42ddceFtJrsebC80KZDxNtQVaz7R7YjOWTwIP_P3Au-sF2fPZLBChzBveN1wJEI_afFw9nLIRkpzJYsrM20PcCkoBPgjAbXa-cBy1TPJ2RHntSDha596M_Awje4LAVIsCHnhoEydsiAOZCkCig1FjCNnRgPzzSsnqUnyDX279e7DdRL57SngPqRiloe6Y0DG81ToxQamqwt9HWBfvFAL-VjqkxYFIq_QtvS6ct6v2SUU_OrnHy5bMxxrVjDQ-Wdpf9-2-mZWuH-l97ACrwO5XycWcaC_U3Jj2UvcAUKMxI4cpSzm73Nk6Yzi0XESZc-Z-HOx4k4joA")
                .and()
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract().response();
        String message = response.jsonPath() .getString("message");
        logger.info(message);
        Assert.assertEquals(200, response.statusCode());
    }
}


//NOTES: token expires in 36s , so it need to produce every time to get true output

// *****output : you are a minor*********