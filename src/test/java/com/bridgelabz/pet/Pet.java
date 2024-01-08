package com.bridgelabz.pet;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
public class Pet {
    @Test
    public void petPost() {
        Response response = given().header("accept", "application/json")
                .header("Content-Type", "application/json").
                header("Content-Type", "application/json")
                .body(
                        "{\n" +
                                "  \"id\": 1,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 0,\n" +
                                "    \"name\": \"string\"\n" +
                                "  },\n" +
                                "  \"name\": \"doggie\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"string\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 0,\n" +
                                "      \"name\": \"string\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}"
                ).post("https://petstore.swagger.io/v2/pet");
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test
    public void getPet() {
        Response response = given().header("accept", " application/json").get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void postPetID() {
        File file=new File("C:\\Users\\Sanket\\Downloads\\dog.jpeg");
        Response response = given().
                header("accept", "application/json")
                .header("Content-Type", "multipart/form-data")
                .multiPart(file)
                .post("https://petstore.swagger.io/v2/pet/3213/uploadImage");

        Assert.assertEquals(response.statusCode(),200);
    }
}
