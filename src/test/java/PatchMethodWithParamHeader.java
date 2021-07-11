import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class PatchMethodWithParamHeader {

    @Test
    public void test_patchMethodWithParamsAndHeader(){

        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstname","Baseer");

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request).
                when().
                patch("/users/105").
                then().statusCode(200).log().all();
    }
}
