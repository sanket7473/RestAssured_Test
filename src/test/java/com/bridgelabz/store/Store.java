package com.bridgelabz.store;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class Store {
    @Test public void postStore()
    {
    Response response=given().header("accept" ,"application/json").header("Content-Type", "application/json").
            body("{\n" +
                    "  \"id\": 1,\n" +
                    "  \"petId\": 23,\n" +
                    "  \"quantity\": 12,\n" +
                    "  \"shipDate\": \"2024-01-05T08:16:21.964Z\",\n" +
                    "  \"status\": \"placed\",\n" +
                    "  \"complete\": true\n" +
                    "}"
            ).post("https://petstore.swagger.io/v2/store/order");

    Assert.assertEquals(response.statusCode(),200);

    }

    @Test public void getStore()
    {
        Response response=given().header("accept"," application/json").get("https://petstore.swagger.io/v2/store/order/1");
        Assert.assertEquals(response.statusCode(),200);
        response.prettyPrint();
    }

    @Test public void getStoreByStatus()
    {
        Response response=given().header("accept","application/json").get("https://petstore.swagger.io/v2/store/inventory");
        Assert.assertEquals(response.statusCode(),200);
    }
}
