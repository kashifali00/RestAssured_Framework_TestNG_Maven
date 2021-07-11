import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

public class getMethod {

    @Test
    public void httpGetMethodCall(){
        given().
                get("https://automationintesting.online/room/").
        then().
                statusCode(200).
                body("rooms.roomid[0]", equalTo(1)).
                body("rooms.roomNumber[0]", equalTo(101)).
                body("rooms.type[0]",equalTo("single")).
                body("rooms.roomPrice[0]", equalTo(100)).
        log().all();

        System.out.println("");
        System.out.println("*************************************************");

        // Get call with to locally developed api

        //set the base URI
        baseURI = "http://localhost:3000";

        given().
                get("/users").
        then().
                statusCode(200).
                log().all();

    }
}
