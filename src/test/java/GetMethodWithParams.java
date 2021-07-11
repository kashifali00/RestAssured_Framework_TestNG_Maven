import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

public class GetMethodWithParams {

    @Test
    public void test_getMethodWithParameters(){
        baseURI = "http://localhost:3000";

        given().
                param("name","Automation").
                get("/subjects").
        then().statusCode(200).log().all();

    }
}
