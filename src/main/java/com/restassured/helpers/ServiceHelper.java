package com.restassured.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.restassured.constants.EndPoints;
import com.restassured.models.Persons;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.restassured.utils.ConfigManager;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.asserts.SoftAssert;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class ServiceHelper {

    // Fetch the data from endpoints
    //POST, PUT , PATCH, GET, DELETE
    // we need to read the config value from here such as baseurl, port etc etc

    private static final String BASE_URL = ConfigManager.getConfigManagerInstance().getKeyValue("baseURL");
    private static final String PORT = ConfigManager.getConfigManagerInstance().getKeyValue("port");
    Random random;
    Persons persons;


    public ServiceHelper(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation(); // if using localhost
        random = new Random();
        persons = new Persons();

    }

    public List<Persons> getAllPersons() {
        List<Persons> personsList = new ArrayList<Persons>();
        Response response = RestAssured.
                given().log().all().contentType(ContentType.JSON).
                get(EndPoints.GET_ALL_PERSON).
                andReturn();
        ResponseBody responseBody = response.getBody();
        if ((response.getStatusCode() == HttpStatus.SC_OK) && (response.getContentType().contains("application/json"))) {

            // We are mapping here the response with Persons pojo file - models -> persons
            // This process is called deserializing
            Type type = new TypeReference<List<Persons>>() {}.getType();
            System.out.println("Response Body :" + responseBody.asString());
            personsList = response.as(type);
        }

        return personsList;
    }

    public Response createPerson(){

        //Serializing with the help of pojo class
        persons.setFirstname("Anas");
        persons.setLastname("Ali");
        persons.setAddress("New Alkaram house");
        persons.setAge(5);
        persons.setId(random.nextInt(900) + 100);

        Response response = RestAssured.given().
                            contentType(ContentType.JSON).
                            accept(ContentType.JSON).
                            header("Content-Type", "application/json").
                            when().
                            body(persons).
                            post(EndPoints.CREATE_PERSON).
                            andReturn();

        ResponseBody responseBody = response.getBody();
        String responseAsString = responseBody.asString();
        if(!responseAsString.isEmpty()){
            System.out.println();
            System.out.println("responseBody :" +responseAsString);
        }
        return response;
    }

    public Response updatePerson(int id, String firstName, String lastName, int age, String address){

        persons.setLastname(lastName);
        persons.setFirstname(firstName);
        persons.setAge(age);
        persons.setAddress(address);

        Response response = RestAssured.given().
                            contentType(ContentType.JSON).accept(ContentType.JSON).
                            header("content-type", "application/json").
                            pathParam("id", id).
                            body(persons).
                            when().
                            put(EndPoints.UPDATE_PERSON).
                            thenReturn();
        return response;
    }
}