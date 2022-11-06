import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;
import utils.PropertiesLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPostTest {


    @Test
    public void addPost() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        String newPost = "{\n" +
                "\"status\": \"publish\",\n" +
                "\"type\": \"post\",\n" +
                "\"title\": \"Test Java Rest Assured\",\n" +
                "\"content\": \"Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym.\",\n" +
                "\"excerpt\": \"Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy .....\",\n" +
                "\"author\": 1,\n" +
                "\"featured_media\": 0,\n" +
                "\"comment_status\": \"open\",\n" +
                "\"ping_status\": \"open\",\n" +
                "\"sticky\": false,\n" +
                "\"template\": \"\",\n" +
                "\"format\": \"standard\",\n" +
                "\"meta\": []\n" +
                "}";
        given().auth().preemptive().basic(login, pass)
                .contentType(ContentType.JSON).body(newPost)
                .when().post(url + "posts/")
                .then().log().all();

    }


    @Test
    public void addPostFromFile() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        File newPost = new File("src/test/resources/post.json");

        given().auth().preemptive().basic(login, pass)
                .contentType(ContentType.JSON).body(newPost)
                .when().post(url + "posts/")
                .then().log().all();

    }


    @Test
    public void addPostFromMap() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        Map<String, Object> newPost = new HashMap<>();
        newPost.put("status", "publish");
        newPost.put("type", "post");
        newPost.put("title", "Test Java Rest Assured");
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
                .contentType(ContentType.JSON).body(newPost)
                .when().post(url + "posts/")
                .then().log().all();
    }

    @Test
    public void addPostFromObject() throws IOException {
        String login = PropertiesLoader.loadProperty("wswoimtempie.login");
        String pass = PropertiesLoader.loadProperty("wswoimtempie.pass");
        String url = PropertiesLoader.loadProperty("wswoimtempie.url");

        Post newPost = new Post();
        newPost.setStatus("publish");
        newPost.setType("post");
        newPost.setTitle("Test Java Rest Assured - 10.20");
        newPost.setContent("Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym.");
        newPost.setExcerpt("Test Java Rest Assured - Lorem Ipsum jest tekstem stosowanym jako przykładowy");
        newPost.setAuthor(1);
        newPost.setFeatured_media(0);
        newPost.setComment_status("open");
        newPost.setPing_status("open");
        newPost.setSticky(false);
        newPost.setTemplate("");
        newPost.setFormat("standard");

        given().auth().preemptive().basic(login, pass)
                .contentType(ContentType.JSON).body(newPost)
                .when().post(url + "posts/")
                .then().log().all();

    }


}



