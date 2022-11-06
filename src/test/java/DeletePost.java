import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeletePost {

    @Test
    public void deletePost() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");
        given().auth().preemptive().basic(login, pass).when().delete(url + "posts/{postId}", 289).then().log().all();
    }
}
