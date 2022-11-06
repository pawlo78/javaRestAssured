import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.IOException;

import static io.restassured.RestAssured.when;

public class GetPostTest {

    @Test
    public void getPost() throws IOException {
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        when().get(url + "posts/290").then().log().all();
    }



}
