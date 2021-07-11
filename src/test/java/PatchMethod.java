import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class PatchMethod {

    @Test
    public void test_patchMethod(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","api engineer");

        given().
                body(request).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }
}
