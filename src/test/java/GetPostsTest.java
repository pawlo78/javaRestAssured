import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.IOException;

import static io.restassured.RestAssured.when;

public class GetPostsTest {


    @Test
    public void getPosts() throws IOException {
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");
        when().get(url + "posts").then().log().all();
    }


}
