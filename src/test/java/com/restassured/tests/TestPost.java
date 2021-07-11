package com.restassured.tests;

import com.restassured.helpers.ServiceHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestPost {

    ServiceHelper serviceHelper;
    SoftAssert softAssert;

    @BeforeClass
    public void init(){
        serviceHelper = new ServiceHelper();
        softAssert = new SoftAssert();
    }

    @Test
    public void testCreatePerson(){
        Response response = serviceHelper.createPerson();
        softAssert.assertNotNull(response);
        softAssert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Person Created Successfully");
        softAssert.assertEquals(response.contentType(), "application/json");
        softAssert.assertNotNull(response.jsonPath().get("id"));

    }
}
