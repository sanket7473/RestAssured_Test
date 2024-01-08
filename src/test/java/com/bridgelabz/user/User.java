package com.bridgelabz.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class User {

    @Test
    public void post(){

        Response response=given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\":123,\n" +
                        "    \"username\": \"Sanket\",\n" +
                        "    \"firstName\": \"string\",\n" +
                        "    \"lastName\": \"string\",\n" +
                        "    \"email\": \"string\",\n" +
                        "    \"password\": \"Sanket\",\n" +
                        "    \"phone\": \"string\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .post("https://petstore.swagger.io/v2/user/createWithArray");

        Assert.assertEquals(response.statusCode(),200);



    }
    @Test
    public void get()
    {
       Response response= given()
                .header("accept", "application/json")
               .pathParams("username","Sanket")
              // .queryParam("username","Sanket")
               .get("https://petstore.swagger.io/v2/user/{username}");

        System.out.println(response.toString());

       Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void put()
    {
        Response response=given().header("accept", "application/json").header("Content-Type", "application/json")
                .body(
                        "{\n" +
                                "  \"id\": 123,\n" +
                                "  \"username\": \"Sanket\",\n" +
                                "  \"firstName\": \"string\",\n" +
                                "  \"lastName\": \"string\",\n" +
                                "  \"email\": \"sanket@123\",\n" +
                                "  \"password\": \"Sanket\",\n" +
                                "  \"phone\": \"string\",\n" +
                                "  \"userStatus\": 0\n" +
                                "}"
                ).put("https://petstore.swagger.io/v2/user/Sanket");
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void deleteUser()
    {
        Response response=given().header("accept", "application/json").delete("https://petstore.swagger.io/v2/user/Sanket");

    }

    @Test
    public void postWithList()
    {
        Response response=given().header("accept"," application/json" )
                .header("Content-Type","application/json").body(
                        "[\n" +
                                "  {\n" +
                                "    \"id\": 123,\n" +
                                "    \"username\": \"Sanket\",\n" +
                                "    \"firstName\": \"string\",\n" +
                                "    \"lastName\": \"string\",\n" +
                                "    \"email\": \"string\",\n" +
                                "    \"password\": \"Sanket\",\n" +
                                "    \"phone\": \"string\",\n" +
                                "    \"userStatus\": 0\n" +
                                "  },\n" +
                                "{\n" +
                                "    \"id\": 124,\n" +
                                "    \"username\": \"Mohit\",\n" +
                                "    \"firstName\": \"string\",\n" +
                                "    \"lastName\": \"string\",\n" +
                                "    \"email\": \"string\",\n" +
                                "    \"password\": \"Mohit\",\n" +
                                "    \"phone\": \"string\",\n" +
                                "    \"userStatus\": 0\n" +
                                "  }\n" +
                                "\n" +
                                "]"
                ).post("https://petstore.swagger.io/v2/user/createWithList");
        Assert.assertEquals(response.statusCode(),200);

    }

}
