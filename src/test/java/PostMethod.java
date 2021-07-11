import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import java.util.Map;

public class PostMethod {

    @Test
    public void test_postcall(){

        Map<String, Object> postBody = new HashMap<String, Object>();
        postBody.put("name","morpheus");
        postBody.put("job","learder");

        JSONObject request = new JSONObject(postBody);
        System.out.println(request);

        given().
                header("content-type","application/json").
                header("charset","utf-8").
                accept("application/json").
                body(request).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201).
                log().all();
    }
}
