package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class BDDStyledMethod {

    public static void simpleGETPost(String postNumber){
        given().contentType(ContentType.JSON);
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author",is("Juan Jose"));
    }

     public static void performPathParameter(){
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post", 8).
        when()
                .get("http://localhost:3000/posts/{post}").

        then()
                .body("author", containsString("Juan Jose"));
     }
    public static void performDelete(){
        given()
                .contentType(ContentType.JSON).
                with()
                .pathParams("post", 8).
                when()
                .delete("http://localhost:3000/posts/{post}").

                then()
                .statusCode(200);
    }

    public static void performPostWithBodyParamether(){
        HashMap<String,String> postContect = new HashMap<String, String>();
        postContect.put("id","8");
        postContect.put("title","Presentacion DEMO ");
        postContect.put("author","Juan Jose");
        postContect.put("company","Endava");
        postContect.put("City"," Medellin");
        postContect.put("Favorite Food","Ajiaco");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(postContect).
        when()
                .post("http://localhost:3000/posts").

        then()
                .body("author", Is.is("Juan Jose"));

    }


}
