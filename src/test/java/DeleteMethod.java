import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class DeleteMethod {

    @Test
    public void test_deleteMethod(){
        when().
                delete("https://reqres.in/api/users/2").
        then().statusCode(204).
        log().all();
    }
}
