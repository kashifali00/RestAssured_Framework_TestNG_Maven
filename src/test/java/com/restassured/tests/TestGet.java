package com.restassured.tests;

import com.restassured.helpers.ServiceHelper;
import com.restassured.models.Persons;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.plaf.IconUIResource;
import java.util.Iterator;
import java.util.List;

public class TestGet {

    ServiceHelper serviceHelper;
    Persons persons;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void serviceHelper(){
        serviceHelper = new ServiceHelper();
        persons = new Persons();

    }

    @Test
    public void testGetAllPerson(){
        List<Persons> allPerson = serviceHelper.getAllPersons();

        softAssert.assertNotNull(allPerson);
        System.out.println("FirsName_Person0 :" + allPerson.get(0).getFirstname());
        System.out.println("FirstName_Person1 :" + allPerson.get(1).getFirstname());

        int age_obj0 = allPerson.get(0).getAge();
        int age_ob1 = allPerson.get(1).getAge();
        int id_obj0 = allPerson.get(0).getId();
        int id_obj1 = allPerson.get(1).getId();

        softAssert.assertEquals(allPerson.get(0).getFirstname(), "Kashif");
        softAssert.assertEquals(allPerson.get(0).getLastname(), "Ali");
        softAssert.assertEquals(allPerson.get(1).getFirstname(), "Waqas");
        softAssert.assertEquals(allPerson.get(1).getLastname(), "Ali");
        softAssert.assertEquals(age_obj0, 32);
        softAssert.assertEquals(age_ob1, 22);
        softAssert.assertEquals(id_obj0, 2);
        softAssert.assertEquals(id_obj1, 3);
        softAssert.assertEquals(allPerson.get(0).getAddress(), "House CB 50, Javed Shaheed Road, Jinnahabad Mandia");
        softAssert.assertAll();

    }
}
