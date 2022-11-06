import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {


    @Test
    public void updatePostMethodPut() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        Map<String, Object> newPost = new HashMap<>();
        newPost.put("status", "publish");
        newPost.put("type", "post");
        newPost.put("title", "Test Java Rest Assured - po aktualizacji 2");
        newPost.put("content", "Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym.");
        newPost.put("excerpt", "Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy");
        newPost.put("author", 1);
        newPost.put("featured_media", 0);
        newPost.put("comment_status", "open");
        newPost.put("ping_status", "open");
        newPost.put("sticky", false);
        newPost.put("template", "");
        newPost.put("format", "standard");

        given().auth().preemptive().basic(login, pass)
                .contentType(ContentType.JSON).body(newPost).pathParam("postId", 290)
                .when().put(url + "posts/{postId}")
                .then().log().all();
    }


    @Test
    public void updatePostFromObjectMethodPatch() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        //nie wysyłamy pól null - def to w klasie Post
        //update tylko jednego pola
        Post newPost = new Post();
        newPost.setTitle("Test Java Rest Assured - 10.39");

        given().auth().preemptive().basic(login, pass)
                .contentType(ContentType.JSON).body(newPost)
                .when().patch(url + "posts/290")
                .then().log().all();
    }
}
