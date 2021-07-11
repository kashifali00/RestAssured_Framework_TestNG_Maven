import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


public class PutMethod {

    @Test
    public void test_putMethod(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","qa engineer");

        given().
                body(request).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();

    }

}
