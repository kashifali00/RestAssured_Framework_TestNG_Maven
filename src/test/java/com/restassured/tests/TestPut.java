package com.restassured.tests;

import com.restassured.helpers.ServiceHelper;
import com.restassured.models.Persons;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.geom.RectangularShape;

public class TestPut {

    ServiceHelper serviceHelper;
    Persons persons;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void serviceHelper(){
        serviceHelper = new ServiceHelper();
        persons = new Persons();

    }

    @Parameters({"id", "firstName", "lastName","age","address"})
    @Test
    public void testUpdatePerson(int id, String firstName, String lastName, int age, String address){
        Response response = serviceHelper.updatePerson(id, firstName, lastName, age, address);
        softAssert.assertNotNull(response);
        softAssert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Person object updated successfully");
        ResponseBody responseBody = response.getBody();
        System.out.println("responseBody :" + responseBody.asString());
    }
}
